package com.lw.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.lw.dao.AdminUserInfoMapper;
import com.lw.model.ActiveAdminModel;
import com.lw.model.AdminPermissionModel;
import com.lw.model.AdminUserInfoModel;
import com.lw.services.RoleService;
import com.lw.services.SysService;

public class UserDetailsService extends AuthorizingRealm{
	
	@Autowired
	private AdminUserInfoMapper adminUserInfoMapper;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SysService sysService;
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return UserDetailsService.class.getName();
	}

//	授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username = (String) principals.getPrimaryPrincipal();		//根据身份信息从数据库获取到权限数据
		List<AdminPermissionModel> permissionList = null;
		try {
			permissionList = sysService.findPermissionListByUserId(username);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		List<String> permissions = new ArrayList<String>();
		if(permissionList!=null){
			for(AdminPermissionModel sysPermission:permissionList){
				permissions.add(sysPermission.getPermissionPerms());
			}
		}
		//查到权限数据，返回授权信息(要包括 上边的permissions)
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		simpleAuthorizationInfo.addStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}
//  认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken userToken = (UsernamePasswordToken)token;
		//2.获取token中的登录账户
		String userCode = userToken.getUsername();
		//3.查询数据库，是否存在指定的用户名和密码的用户(主键/账户/密码/账户状态/盐)
		AdminUserInfoModel us = null;
		us = adminUserInfoMapper.getUserByUserName(userCode);
		//4.1 如果没有查询到，抛出异常
		if( us == null ) {
			throw new UnknownAccountException("账户"+userCode+"不存在！");
		}
		//4.2 如果查询到了，封装查询结果，
		Object adminName = us.getAdminName();
		Object credentials = us.getAdminPass();
		String salt = us.getSalt();
		//获取盐，用于对密码在加密算法(MD5)的基础上二次加密ֵ
		ByteSource byteSalt = ByteSource.Util.bytes(salt);
		//5. 返回给调用login(token)方法
		return new SimpleAuthenticationInfo(adminName, credentials, byteSalt, this.getName());
	}
	
	@Override
	protected void clearCache(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		super.clearCache(principals);
	}
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
	
	@Override
	protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		super.clearCachedAuthenticationInfo(principals);
	}
	@Override
	protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		super.clearCachedAuthorizationInfo(principals);
	}
	
	/**
     * 自定义方法：清除所有 认证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 自定义方法：清除所有的  认证缓存  和 授权缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }
}

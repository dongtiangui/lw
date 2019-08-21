package com.lw.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lw.dao.AdminPermissionMapper;
import com.lw.dao.AdminUserInfoMapper;
import com.lw.dao.UserInfoMapper;
import com.lw.model.AdminPermissionModel;
import com.lw.model.AdminRole;
import com.lw.model.AdminUserInfoModel;
import com.lw.model.UserInfoModel;
import com.lw.services.SysService;

@Service
public class SysServiceImpl implements SysService{
	
	@Autowired
	private AdminUserInfoMapper adminUserInfoMapper;
	
	@Autowired
	private AdminPermissionMapper adminPermissionMapper;

	
	
	@Override
	public List<AdminPermissionModel> findPermissionListByUserId(String userId) {
		// TODO Auto-generated method stub
		AdminUserInfoModel aInfoModel = this.adminUserInfoMapper.findAdminUserInfoModel(userId);
		if(aInfoModel != null){
			AdminRole adminRole = aInfoModel.getAdminRole();
			if (adminRole != null) {
				return adminPermissionMapper.findPermissionList(adminRole.getId());
			}
		}
		return null;
	}

}

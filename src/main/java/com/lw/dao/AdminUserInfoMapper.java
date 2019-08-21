package com.lw.dao;

import java.util.List;
import com.lw.model.AdminUserInfoModel;

public interface AdminUserInfoMapper {
	 	AdminUserInfoModel getUserByUserName(String adminName);
	    // 注册用户
	    int addUser(AdminUserInfoModel tbUser);

	    AdminUserInfoModel findAdminUserInfoModel(String adminName);
	    
	    // 查询所有用户信息
	    List<AdminUserInfoModel> getAllUser();

	    // 删除用户信息及其关联角色信息
	    void deleteUser(Integer adminId);
	    
	    void deleteUserRole(Integer adminId);
	
	    List<AdminUserInfoModel> find(AdminUserInfoModel record);
		
		int deleteBatch(String[] ids);
		
		int changeStatus(String[] ids);

	    int deleteByPrimaryKey(String id);

	    int insert(AdminUserInfoModel user);

	    int insertSelective(AdminUserInfoModel user);

	    AdminUserInfoModel selectByPrimaryKey(String id);

	    int updateByPrimaryKeySelective(AdminUserInfoModel user);

	    int updateByPrimaryKey(AdminUserInfoModel user);

		List<AdminUserInfoModel> searchUserByUserId(String userId);

		List<AdminUserInfoModel> searchUserByUserName(String userName);

		List<AdminUserInfoModel> searchUserByRoleName(String roleName);

}

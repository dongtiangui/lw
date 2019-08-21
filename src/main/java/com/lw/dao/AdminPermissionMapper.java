package com.lw.dao;

import java.util.List;

import com.lw.model.AdminPermissionModel;

public interface AdminPermissionMapper {
	
	String findRoleByUserId(String uid);
	
	List<AdminPermissionModel> findPermission(String ids[]);
	 
	List<AdminPermissionModel> findPermissionList(Integer role);
	
    int deleteByPrimaryKey(Long id);

    int insert(AdminPermissionModel record);

    int insertSelective(AdminPermissionModel record);

    AdminPermissionModel selectByPrimaryKey(Long id);
 
    int updateByPrimaryKeySelective(AdminPermissionModel record);

    int updateByPrimaryKey(AdminPermissionModel record);
	

}

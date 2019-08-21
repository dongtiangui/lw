package com.lw.dao;

import java.util.List;

import com.lw.model.AdminRole;

public interface AdminRoleMapper {

	int deleteByPrimaryKey(String id);

	int insert(AdminRole role);

	int insertSelective(AdminRole role);

	AdminRole selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(AdminRole role);

	int updateByPrimaryKey(AdminRole role);

	List<AdminRole> searchRoleByRoleId(String roleId);

	List<AdminRole> searchRoleByRoleName(String roleName);

}

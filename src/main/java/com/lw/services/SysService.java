package com.lw.services;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lw.model.AdminPermissionModel;
import com.lw.model.UserInfoModel;

public interface SysService {
	
	public List<AdminPermissionModel> findPermissionListByUserId(String userId);
	
	

}

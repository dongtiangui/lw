package com.lw.services;

import com.github.pagehelper.PageInfo;
import com.lw.model.UserInfoModel;

public interface UserInfoServices {
	
	
	public PageInfo<UserInfoModel> lInfoModels(Integer pageNum,Integer pageSize);
	

}

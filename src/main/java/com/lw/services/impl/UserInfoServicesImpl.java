package com.lw.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lw.dao.UserInfoMapper;
import com.lw.model.UserInfoModel;
import com.lw.services.UserInfoServices;

@Service
public class UserInfoServicesImpl implements UserInfoServices{

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Cacheable(value="keyuser",key="#user")
	@Override
	public PageInfo<UserInfoModel> lInfoModels(Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<UserInfoModel> uInfoModels = userInfoMapper.findUserByUserCode();
		PageInfo<UserInfoModel> pageInfo = new PageInfo<UserInfoModel>(uInfoModels);
		return pageInfo;
	}
}

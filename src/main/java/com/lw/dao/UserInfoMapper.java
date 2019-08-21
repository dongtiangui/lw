package com.lw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.lw.model.UserInfoModel;


@Mapper
public interface UserInfoMapper {
	
	
//	findUserByUserCode
	List<UserInfoModel> findUserByUserCode();

}

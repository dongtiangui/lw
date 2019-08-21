package com.lw.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lw.dao.AnnounCement;
import com.lw.model.AnnounCementModel;
import com.lw.services.AnnounCementServices;

@Service
public class AnnounCementImpl implements AnnounCementServices{
	
	@Autowired
	private AnnounCement announCement;

	@Override
	public PageInfo<AnnounCementModel> findList(int pageSize,int pageNum) {
		PageHelper.startPage(pageSize,pageNum);
		List<AnnounCementModel> aList = announCement.findAll();
		Optional<List<AnnounCementModel>> optional = Optional.of(aList);
		PageInfo<AnnounCementModel> pageInfo = new PageInfo<AnnounCementModel>(optional.get());
		return pageInfo;
	}
}

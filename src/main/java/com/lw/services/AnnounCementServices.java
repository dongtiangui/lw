package com.lw.services;

import com.github.pagehelper.PageInfo;
import com.lw.model.AnnounCementModel;

public interface AnnounCementServices {
	
	PageInfo<AnnounCementModel> findList(int pageSize,int pageNum);

}

package com.lw.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageInfo;
import com.lw.base.BaseQueryRequest;
import com.lw.base.BaseTableResult;
import com.lw.dao.UserInfoMapper;
import com.lw.model.UserInfoModel;

import com.lw.services.UserInfoServices;

@Controller
@RequestMapping(value = "/tab")
public class StaticController {
	
	@Autowired
	private UserInfoServices sysService;
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	@RequestMapping(value = "/tabhome")
	public String tabhome() {
		return "console";
	}
	@RequestMapping(value = "/system-log")
	public String systemlog() {
		return "systemlog";
	}
	@RequestMapping(value = "/system-setting")
	public String systemsetting() {
		return "systemsetting";
	}

	@RequestMapping(value = "/system-back")
	public String systemback() {
		return "systemback";
	}
	@RequestMapping(value="/system-announcement")
	public String systemannouncement() {
		return "systemannouncement";
	}
	@RequestMapping(value="/table/ajax", method = RequestMethod.POST)
	@ResponseBody
	public BaseTableResult<UserInfoModel> userInfoTable(@RequestBody BaseQueryRequest queryRequest) {
		PageInfo<UserInfoModel> uInfoModels = sysService.lInfoModels(queryRequest.getStart()+1,queryRequest.getLength());
	    BaseTableResult<UserInfoModel> dResult = new BaseTableResult<UserInfoModel>();
	    dResult.setDraw(queryRequest.getDraw());
	    //过滤后的数量
	    dResult.setRecordsFiltered((int) uInfoModels.getTotal());
	    //总共的数量
	    dResult.setRecordsTotal((int) uInfoModels.getTotal());
	    dResult.setAaData(uInfoModels.getList());
	    return dResult;
	}
}

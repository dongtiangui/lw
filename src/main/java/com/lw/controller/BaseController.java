
package com.lw.controller;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lw.common.BaseInterface;
import com.lw.configuration.DynamicDataSource;
import com.lw.model.AdminPermissionModel;
import com.lw.services.SysService;

@Controller
public class BaseController{

	@Autowired
	private SysService sysService;
	
	@Autowired
	private BaseInterface baseInterface;
	
	@RequiresPermissions("list:add")
	@RequestMapping(value = "/index")
	public String Index() {
		List<AdminPermissionModel> list = sysService.findPermissionListByUserId("董天贵");
		for (AdminPermissionModel adminPermissionModel : list) {
			System.out.println(adminPermissionModel);
		}
		return "home";
	}

	@RequestMapping(value = "/login/ajaxLogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitLogin(@RequestParam(value = "name") String username,
			@RequestParam(value = "pass") String password) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		Subject currentUser = SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()) {
			try {
				DynamicDataSource.clearCustomerType();
				DynamicDataSource.setCustomerType(DynamicDataSource.mysqldataSource);
				UsernamePasswordToken token = new UsernamePasswordToken(username, password);
				currentUser.login(token);
				resultMap.put("status", 200);
				resultMap.put("message", "登录成功");
				baseInterface.startFtpServer();
			} catch (Exception e) {
				resultMap.put("status", 500);
				resultMap.put("message", e.getMessage());
			}
		}
		return resultMap;
	}
	@RequestMapping(value = "/home")
	public String home() {
		return "home";
	}
}

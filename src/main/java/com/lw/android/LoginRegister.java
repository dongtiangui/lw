package com.lw.android;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/user")
public class LoginRegister {
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Map<String, Object> addList(@RequestParam("json")String json){
		
		System.out.println(json);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("我是from表单提交", "===================");
		return map; 
	}
}

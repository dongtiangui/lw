package com.lw.android;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 广告接口
 * @author apple
 *
 */
@RestController
@RequestMapping(value="/api/ad")
public class AdController {
	
	@RequestMapping(value="/adList",method=RequestMethod.GET)
	public Map<String, Object> addList(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("123", "===================");
		return map; 
	}
}

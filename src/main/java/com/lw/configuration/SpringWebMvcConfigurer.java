package com.lw.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringWebMvcConfigurer implements WebMvcConfigurer{
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
//		registry.addRedirectViewController("/hello", "/home");
//	    // 对 "/admin/**" 的请求 返回 404 的 http 状态
//	    registry.addStatusController("/admin/**", HttpStatus.NOT_FOUND);
//	    // 将 "/home" 的 请求响应为返回 "home" 的视图 
	    registry.addViewController("/system-log").setViewName("systemlog");
	    
	    registry.addViewController("/system-setting").setViewName("systemsetting");

	}

}

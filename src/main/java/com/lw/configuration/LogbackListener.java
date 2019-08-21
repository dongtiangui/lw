package com.lw.configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ch.qos.logback.ext.spring.web.WebLogbackConfigurer;

public class LogbackListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		WebLogbackConfigurer.initLogging(sce.getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		WebLogbackConfigurer.shutdownLogging(sce.getServletContext());
	}

}

package com.lw.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{
	public static final String mysqldataSource = "mysqldataSource";
	public static final String postgresqldataSource = "postgresqldataSource";
	public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return getCustomerType();
	}
	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}
	public static String getCustomerType() {
		return contextHolder.get();
	}
	public static void clearCustomerType() {
		contextHolder.remove();
	}
}

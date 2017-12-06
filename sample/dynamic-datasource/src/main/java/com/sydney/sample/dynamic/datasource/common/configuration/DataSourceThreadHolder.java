package com.sydney.sample.dynamic.datasource.common.configuration;

public class DataSourceThreadHolder {
	
	public static ThreadLocal<String> context = new ThreadLocal<>();

}

package com.sydney.sample.dynamic.datasource.common.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class DynamicDataSource extends AbstractRoutingDataSource {
	
	public static ThreadLocal<String> context = new ThreadLocal<>();

	@Override
	protected Object determineCurrentLookupKey() {
		 return DataSourceThreadHolder.context.get();
	}

}

package com.sydney.sample.feature.function.service;

public interface ManufactureService {
	
	default String getCanonicalName() {
		return ManufactureService.class.getCanonicalName();
	}
	
	
	public String manufacture(Object object);

}

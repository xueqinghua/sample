package com.sydney.sample.feature.function.service;

import static org.junit.Assert.*;

import javax.print.attribute.standard.RequestingUserName;

import org.junit.Test;

public class LambdaTest {

	@Test
	public void testManufacture() {
		ManufactureService manufactureService = (object) -> {return object.toString()+"----------";};
		
		System.out.println(manufactureService.manufacture("test"));
	}
	
	
	@Test
	public void testColon() {
		ManufactureService manufactureService =  String::valueOf;
		
		System.out.println(manufactureService.manufacture("test"));
	}

}

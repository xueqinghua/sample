package com.sydney.sample.feature.customer.entity;

public class Customer extends Person {
	
	
	static {
		System.out.println("Customer static { }");
	}
	
	{
		System.out.println("Customer { }");
	}	
}

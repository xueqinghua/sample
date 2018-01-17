package com.sydney.sample.customer.entity;

public class Person {
	private String id;
	private String name;
	private Integer age;
	
	
	static {
		System.out.println("Customer static { }");
	}
	
	
	{
		System.out.println("Customer { }");
	}
	
	public Integer getAge() {
		return age;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}

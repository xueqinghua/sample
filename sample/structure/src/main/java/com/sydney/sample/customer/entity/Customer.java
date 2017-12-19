package com.sydney.sample.customer.entity;

public class Customer {
	
	private String id;
	private String name;
	private Integer age;
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

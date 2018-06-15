package com.sydney.sample.algorithm.customer.entity;

import com.sydney.sample.algorithm.common.entity.BaseEntity;

public class Customer extends BaseEntity {
	
	private String name;
	private String mobile;
	
	private Integer age;
	public String getMobile() {
		return mobile;
	}
	public String getName() {
		return name;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}

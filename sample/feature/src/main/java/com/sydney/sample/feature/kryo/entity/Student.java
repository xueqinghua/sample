package com.sydney.sample.feature.kryo.entity;

public class Student {
	
	private String id;

	private String name;

	private String degree;
	
	private String profession;
	
	private String education;

	public String getDegree() {
		return degree;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}

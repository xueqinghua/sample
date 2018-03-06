package com.sydney.sample.security.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private String gender;
	@Column
	private Integer age;
	@Column
	private Double height;
	@Column
	private String profession;
	public Integer getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public Double getHeight() {
		return height;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getProfession() {
		return profession;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}

}

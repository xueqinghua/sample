package com.sydney.sample.security.user.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sydney.sample.security.user.entity.User;

public interface UserDao extends JpaRepository<User, Serializable>{
	
	

}

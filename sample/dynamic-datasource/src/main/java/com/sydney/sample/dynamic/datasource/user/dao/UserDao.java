package com.sydney.sample.dynamic.datasource.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sydney.sample.dynamic.datasource.user.entity.User;


@Repository
public interface UserDao {
	
	
	public void insert(User user);
	
	List<User> findList(User user);

}

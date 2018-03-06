package com.sydney.sample.security.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sydney.sample.security.user.dao.UserDao;
import com.sydney.sample.security.user.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public List<User> findList(){
		return userDao.findAll();
	}
}

package com.sydney.sample.security.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.sydney.sample.security.user.dao.UserDao;
import com.sydney.sample.security.user.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public List<User> findList(User user) {
		Example<User> example = Example.of(user);
		return userDao.findAll(example);
	}
}

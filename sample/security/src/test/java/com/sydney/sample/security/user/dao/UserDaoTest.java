package com.sydney.sample.security.user.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import com.sydney.sample.security.BaseTest;
import com.sydney.sample.security.user.entity.User;

public class UserDaoTest extends BaseTest {
	
	@Autowired
	private UserDao userDao;

	@Test
	public void test() {
		List<User> users = new ArrayList<>();
		
		for(int i=0;i<100;i++) {
			User user = new User();
			user.setName("name_"+i);
			user.setGender("gender_"+(i%2==0?"male":"female"));
			user.setHeight(Double.valueOf(i));
			user.setAge(i);
			user.setPassword("password_"+i);
			user.setProfession("profession_"+i);
			users.add(user);
		}
		
		userDao.save(users);
	}
	
	@Test
	public void testFindOne() {
		User entity = new User();
		entity.setName("name_1");
		
		Example<User> example = Example.of(entity);
		
		
		User user = userDao.findOne(example);
		
		System.out.println(user.getName());
		
		
	}

}

package com.sydney.sample.dynamic.datasource.user.dao;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sydney.sample.dynamic.datasource.common.BaseTest;
import com.sydney.sample.dynamic.datasource.common.configuration.DataSourceThreadHolder;
import com.sydney.sample.dynamic.datasource.customer.dao.CustomerDao;
import com.sydney.sample.dynamic.datasource.user.entity.User;


public class UserDaoTest extends BaseTest {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CustomerDao customerDao;

	@Test
	public void testSave() {
		try {
			
			DataSourceThreadHolder.context.set("yoa");
			
			User user = new User();
			user.setName("name_1");
			userDao.insert(user);
			Assert.assertTrue(userDao.findList(user).size()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-----------");
	}

}

package com.sydney.sample.security.common.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sydney.sample.security.user.dao.UserDao;
import com.sydney.sample.security.user.entity.User;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User entity = new User();
		entity.setName(username);
		
		Example<User> example = Example.of(entity);
		
		User user = userDao.findOne(example);
		
		if (user==null) {
			throw new UsernameNotFoundException("username not exists");
		}
		
		
		
		
		return user;
	}

}

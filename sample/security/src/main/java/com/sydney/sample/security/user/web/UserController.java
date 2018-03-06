package com.sydney.sample.security.user.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sydney.sample.security.user.entity.User;
import com.sydney.sample.security.user.service.UserService;

@RequestMapping("user")
@Controller("userControllerCustom")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	public String list(Model model) {
		List<User> users = userService.findList();
		
		model.addAttribute("userList", users);
		
		return "userList";
	}

}

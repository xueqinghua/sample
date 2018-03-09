package com.sydney.sample.security.user.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sydney.sample.security.user.entity.User;
import com.sydney.sample.security.user.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="list",method= {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		List<User> users = userService.findList(new User());
		
		model.addAttribute("userList", users);
		
		return "userList";
	}

}

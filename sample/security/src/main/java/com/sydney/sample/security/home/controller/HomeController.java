package com.sydney.sample.security.home.controller;

import org.springframework.ui.Model;

import com.sydney.sample.security.user.entity.User;

//@Controller
public class HomeController {
	
	//@RequestMapping("/")
	public String index(Model model) {
		
		
		User simulationUser = new User();
		simulationUser.setName("simulation");
		simulationUser.setProfession("证券分析师");
		
		model.addAttribute("user", simulationUser);
		
		return "index";
	}

}

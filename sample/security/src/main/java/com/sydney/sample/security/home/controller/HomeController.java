package com.sydney.sample.security.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sydney.sample.security.user.entity.User;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@RequestMapping("/index")
	public String index(Model model) {
		
		
		User simulationUser = new User();
		simulationUser.setName("simulation");
		simulationUser.setProfession("证券分析师");
		
		model.addAttribute("user", simulationUser);
		
		return "index";
	}

}

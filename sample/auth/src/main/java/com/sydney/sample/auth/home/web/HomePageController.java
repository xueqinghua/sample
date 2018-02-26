package com.sydney.sample.auth.home.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageController {
	
	@RequestMapping(value= {"","index"})
	public String homePage(Model model) {
		model.addAttribute("name","root");
		return "index";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public Principal user(Principal principal) {
		
		
	    return principal;
	}
	
	@RequestMapping("/logouttest")
	@ResponseBody
	public Principal logout(Principal principal) {
		
		
	    return principal;
	}

}

package com.spring.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(HttpServletRequest request) {
//		if (request.isUserInRole("ROLE_ADMIN")) {
//			System.out.println("Has Role Admin !");
//		} else 
//			System.out.println("Dont have a role Admin");
		return "admin";
	}
}

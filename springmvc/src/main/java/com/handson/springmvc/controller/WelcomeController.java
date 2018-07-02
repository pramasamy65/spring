package com.handson.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping(value="/welcome")
	public String greetings(Model model) {
		System.out.println("Welcome to Spring MVC");
		model.addAttribute("message", "Welcome to Spring MVC World...");
		return "greetings";
	}
}

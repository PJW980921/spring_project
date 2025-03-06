package com.boardcafe.boardcafe_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/")
	public String returnHome() {
		return "index";
	}
	
	@GetMapping("/signin")
	public String SignIn() {
		return "signin/index";
	}
	
	@GetMapping("/signup")
	public String SignUp() {
		return "signup/index";
	}
}

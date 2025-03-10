package com.boardcafe.boardcafe_project.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

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
	public String SignUp(HttpServletRequest request, Model model) {
		CsrfToken csrfToken = (CsrfToken)request.getAttribute(CsrfToken.class.getName());
		model.addAttribute("_csrf", csrfToken);
		return "signup/index";
	}
}

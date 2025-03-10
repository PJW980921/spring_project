package com.boardcafe.boardcafe_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boardcafe.boardcafe_project.entity.Role;
import com.boardcafe.boardcafe_project.entity.User;
import com.boardcafe.boardcafe_project.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/signup")
	public String signup(@ModelAttribute User user) {
		String userPassword = user.getPassword();
		System.out.println("PW:" + userPassword);
		user.setRole(Role.MEMBER);
		String passwordEncoded = passwordEncoder.encode(userPassword);
		user.setPassword(passwordEncoded);
		userService.insertUser(user);
		return "redirect:/signin";
	}
}

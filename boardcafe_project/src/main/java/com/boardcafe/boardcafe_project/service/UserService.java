package com.boardcafe.boardcafe_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boardcafe.boardcafe_project.entity.User;
import com.boardcafe.boardcafe_project.mapper.UserMapper;

@Service
public class UserService {

@Autowired
private UserMapper userMapper;

	public void insertUser(User user) {
		userMapper.InsertUser(user);
	}
	
	public String findWriter(String username) {
		return userMapper.findWriter(username);
	}
}

package com.boardcafe.boardcafe_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boardcafe.boardcafe_project.entity.CustomUser;
import com.boardcafe.boardcafe_project.entity.User;
import com.boardcafe.boardcafe_project.mapper.UserMapper;

@Service
public class UserDetailServicempl implements UserDetailsService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userMapper.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username +"존재하지 않은 아이 입니다.");	
		}
		return new CustomUser(user);
	}
}

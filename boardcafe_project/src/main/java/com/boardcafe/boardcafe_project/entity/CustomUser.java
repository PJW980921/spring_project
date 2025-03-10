package com.boardcafe.boardcafe_project.entity;

import org.springframework.security.core.authority.AuthorityUtils;

public class CustomUser extends org.springframework.security.core.userdetails.User {
	
private User user;

public CustomUser(com.boardcafe.boardcafe_project.entity.User user ) {
	super(user.getUsername(), user.getPassword(),AuthorityUtils.createAuthorityList(user.getRole().toString()));
}

	
}

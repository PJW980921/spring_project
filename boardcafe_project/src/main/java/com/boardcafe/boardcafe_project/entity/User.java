package com.boardcafe.boardcafe_project.entity;

public class User {
	private int id;
	private String username;
	private String password;
	private String writer;
	private Role role;
	
	public User() {}
	
	public User(int id, String username, String password, String writer, Role role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.writer = writer;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}

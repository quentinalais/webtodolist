package com.quentin.web.jdbc;

public class Instructor {
	
	private String username;
	private String password;
	private String role;
	
	public Instructor(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Instructor [username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	

}

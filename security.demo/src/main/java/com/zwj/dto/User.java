package com.zwj.dto;

import com.fasterxml.jackson.annotation.JsonView;

public class User {
	
    public interface usersimple {};
    public interface userdetail extends usersimple{};
	
    
    private String  username;
    private String  password;
    
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User() {
	}
	@JsonView(usersimple.class)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	@JsonView(userdetail.class)
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}

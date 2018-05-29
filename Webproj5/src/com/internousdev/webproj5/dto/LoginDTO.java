package com.internousdev.webproj5.dto;

public class LoginDTO {
	private String password;
	private String username;

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}public String getUserName(){
		return username;
	}
	public void setUserName(String username){
		this.username = username;
	}
}

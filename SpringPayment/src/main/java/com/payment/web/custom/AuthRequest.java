package com.payment.web.custom;

public class AuthRequest {
    private String username;
    private String userPassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public AuthRequest(String username, String userPassword) {
		this.username = username;
		this.userPassword = userPassword;
	}
	public AuthRequest() {
		
	}
	@Override
	public String toString() {
		return "AuthRequest [username=" + username + ", userPassword=" + userPassword + "]";
	}
	
}
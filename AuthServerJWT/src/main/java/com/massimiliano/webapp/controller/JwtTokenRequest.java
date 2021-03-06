package com.massimiliano.webapp.controller;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtTokenRequest implements Serializable 
{

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;


	public JwtTokenRequest() {
	}

	public JwtTokenRequest(String username, String password) {
		this.username = username;
		this.password = password;
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
}

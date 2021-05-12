package com.massimiliano.webapp.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties("gestuser")
@Data
public class UserConfig {
    private String srvUrl;
    private String userId;
    private String password;

	public UserConfig() {
	}

	public UserConfig(String srvUrl, String userId, String password) {
		this.srvUrl = srvUrl;
		this.userId = userId;
		this.password = password;
	}

	public String getSrvUrl() {
		return srvUrl;
	}

	public void setSrvUrl(String srvUrl) {
		this.srvUrl = srvUrl;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

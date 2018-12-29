package com.springboot.springboot.dto;

import java.io.Serializable;

public class SessionDTO implements Serializable {
	private static final long serialVersionUID = -2437186301461673321L;
	private String token = null;
	private String userId = null;
	private String role = null;
	private String pId = null;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	@Override
	public String toString() {
		return "SessionDTO [token=" + token + ", userId=" + userId + ", role=" + role + ", pId=" + pId + "]";
	}

}

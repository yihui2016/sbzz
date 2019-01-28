package com.springboot.springboot.dao.model;

public class UserLog extends BaseBeanResource {
	public static final String CATEGORY_LOGIN = "LOGIN";
	public static final String CATEGORY_LOGOUT = "LOGOUT";
	
	private Long creationTime;
	
	private String userId;

	private String category = null;

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
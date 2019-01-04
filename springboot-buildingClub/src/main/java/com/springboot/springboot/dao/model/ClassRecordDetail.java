package com.springboot.springboot.dao.model;

public class ClassRecordDetail extends BaseBeanResource {
	private String classRecordId;

	@AcceptNewValue
	private String name;

	@AcceptNewValue
	private String strength;

	@AcceptNewValue
	private String times;

	@AcceptNewValue
	private String round;

	@AcceptNewValue
	private String extraInfo;
	
	private Boolean deleteFlag;

	public String getClassRecordId() {
		return classRecordId;
	}

	public void setClassRecordId(String classRecordId) {
		this.classRecordId = classRecordId == null ? null : classRecordId.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength == null ? null : strength.trim();
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times == null ? null : times.trim();
	}

	public String getRound() {
		return round;
	}

	public void setRound(String round) {
		this.round = round == null ? null : round.trim();
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo == null ? null : extraInfo.trim();
	}

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
}
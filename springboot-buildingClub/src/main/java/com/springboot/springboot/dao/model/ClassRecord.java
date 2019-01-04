package com.springboot.springboot.dao.model;

public class ClassRecord  extends BaseBeanResource{
    private String userId;

    private Long creationTime;

    private String creatorId;

    @AcceptNewValue
    private Long startTime;

    @AcceptNewValue
    private Long endTime;

    @AcceptNewValue
    private String target;

    @AcceptNewValue
    private String eatStatus;

    @AcceptNewValue
    private String bodyStatus;

    @AcceptNewValue
    private String sleepStatus;

    @AcceptNewValue
    private String briefInfo;

    @AcceptNewValue
    private String afterStatus;

    @AcceptNewValue
    private String review;

    @AcceptNewValue
    private String coachCheck;

    @AcceptNewValue
    private String userCheck;

    private Boolean deleteFlag;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Long creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getEatStatus() {
        return eatStatus;
    }

    public void setEatStatus(String eatStatus) {
        this.eatStatus = eatStatus == null ? null : eatStatus.trim();
    }

    public String getBodyStatus() {
        return bodyStatus;
    }

    public void setBodyStatus(String bodyStatus) {
        this.bodyStatus = bodyStatus == null ? null : bodyStatus.trim();
    }

    public String getSleepStatus() {
        return sleepStatus;
    }

    public void setSleepStatus(String sleepStatus) {
        this.sleepStatus = sleepStatus == null ? null : sleepStatus.trim();
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo == null ? null : briefInfo.trim();
    }

    public String getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(String afterStatus) {
        this.afterStatus = afterStatus == null ? null : afterStatus.trim();
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review == null ? null : review.trim();
    }

    public String getCoachCheck() {
        return coachCheck;
    }

    public void setCoachCheck(String coachCheck) {
        this.coachCheck = coachCheck == null ? null : coachCheck.trim();
    }

    public String getUserCheck() {
        return userCheck;
    }

    public void setUserCheck(String userCheck) {
        this.userCheck = userCheck == null ? null : userCheck.trim();
    }

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
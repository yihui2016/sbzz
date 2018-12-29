package com.springboot.springboot.dao.model;

public class ClassRecord {
    private String id;

    private String userId;

    private Long creationTime;

    private String creatorId;

    private Long startTime;

    private Long endTime;

    private String target;

    private String eatStatus;

    private String bodyStatus;

    private String sleepStatus;

    private String briefInfo;

    private String afterStatus;

    private String review;

    private String coachCheck;

    private String userCheck;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

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
}
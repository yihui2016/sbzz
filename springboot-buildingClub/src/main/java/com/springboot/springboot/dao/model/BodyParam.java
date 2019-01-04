package com.springboot.springboot.dao.model;

public class BodyParam  extends BaseBeanResource {
    private String userId;

    private Long creationTime;

    private String creatorId;

    private Integer weight;

    private String bust;

    private String waistline;

    private String hipline;

    private String leftArm;

    private String rightArm;

    private String leftThigh;

    private String rightThigh;

    private String extraInfo;

    private String imguri;

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getBust() {
        return bust;
    }

    public void setBust(String bust) {
        this.bust = bust == null ? null : bust.trim();
    }

    public String getWaistline() {
        return waistline;
    }

    public void setWaistline(String waistline) {
        this.waistline = waistline == null ? null : waistline.trim();
    }

    public String getHipline() {
        return hipline;
    }

    public void setHipline(String hipline) {
        this.hipline = hipline == null ? null : hipline.trim();
    }

    public String getLeftArm() {
        return leftArm;
    }

    public void setLeftArm(String leftArm) {
        this.leftArm = leftArm == null ? null : leftArm.trim();
    }

    public String getRightArm() {
        return rightArm;
    }

    public void setRightArm(String rightArm) {
        this.rightArm = rightArm == null ? null : rightArm.trim();
    }

    public String getLeftThigh() {
        return leftThigh;
    }

    public void setLeftThigh(String leftThigh) {
        this.leftThigh = leftThigh == null ? null : leftThigh.trim();
    }

    public String getRightThigh() {
        return rightThigh;
    }

    public void setRightThigh(String rightThigh) {
        this.rightThigh = rightThigh == null ? null : rightThigh.trim();
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo == null ? null : extraInfo.trim();
    }

    public String getImguri() {
        return imguri;
    }

    public void setImguri(String imguri) {
        this.imguri = imguri == null ? null : imguri.trim();
    }
}
package com.springboot.springboot.dto;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


import org.springframework.validation.annotation.Validated;



/**
 * ClassRecordDTO
 */
@Validated



  


public class ClassRecordDTO implements Serializable{
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("creationTime")
  private Long creationTime = null;

  @JsonProperty("creatorId")
  private String creatorId = null;

  @JsonProperty("startTime")
  private Long startTime = null;

  @JsonProperty("endTime")
  private Long endTime = null;

  @JsonProperty("target")
  private String target = null;

  @JsonProperty("eatStatus")
  private String eatStatus = null;

  @JsonProperty("bodyStatus")
  private String bodyStatus = null;

  @JsonProperty("sleepStatus")
  private String sleepStatus = null;

  @JsonProperty("briefInfo")
  private String briefInfo = null;

  @JsonProperty("afterStatus")
  private String afterStatus = null;

  @JsonProperty("review")
  private String review = null;

  @JsonProperty("coachCheck")
  private String coachCheck = null;

  @JsonProperty("userCheck")
  private String userCheck = null;

  public ClassRecordDTO id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ClassRecordDTO userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public ClassRecordDTO creationTime(Long creationTime) {
    this.creationTime = creationTime;
    return this;
  }

  /**
   * Get creationTime
   * @return creationTime
  **/
  


  public Long getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Long creationTime) {
    this.creationTime = creationTime;
  }

  public ClassRecordDTO creatorId(String creatorId) {
    this.creatorId = creatorId;
    return this;
  }

  /**
   * Get creatorId
   * @return creatorId
  **/
  


  public String getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(String creatorId) {
    this.creatorId = creatorId;
  }

  public ClassRecordDTO startTime(Long startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
  **/
  


  public Long getStartTime() {
    return startTime;
  }

  public void setStartTime(Long startTime) {
    this.startTime = startTime;
  }

  public ClassRecordDTO endTime(Long endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
  **/
  


  public Long getEndTime() {
    return endTime;
  }

  public void setEndTime(Long endTime) {
    this.endTime = endTime;
  }

  public ClassRecordDTO target(String target) {
    this.target = target;
    return this;
  }

  /**
   * Get target
   * @return target
  **/
  


  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public ClassRecordDTO eatStatus(String eatStatus) {
    this.eatStatus = eatStatus;
    return this;
  }

  /**
   * Get eatStatus
   * @return eatStatus
  **/
  


  public String getEatStatus() {
    return eatStatus;
  }

  public void setEatStatus(String eatStatus) {
    this.eatStatus = eatStatus;
  }

  public ClassRecordDTO bodyStatus(String bodyStatus) {
    this.bodyStatus = bodyStatus;
    return this;
  }

  /**
   * Get bodyStatus
   * @return bodyStatus
  **/
  


  public String getBodyStatus() {
    return bodyStatus;
  }

  public void setBodyStatus(String bodyStatus) {
    this.bodyStatus = bodyStatus;
  }

  public ClassRecordDTO sleepStatus(String sleepStatus) {
    this.sleepStatus = sleepStatus;
    return this;
  }

  /**
   * Get sleepStatus
   * @return sleepStatus
  **/
  


  public String getSleepStatus() {
    return sleepStatus;
  }

  public void setSleepStatus(String sleepStatus) {
    this.sleepStatus = sleepStatus;
  }

  public ClassRecordDTO briefInfo(String briefInfo) {
    this.briefInfo = briefInfo;
    return this;
  }

  /**
   * Get briefInfo
   * @return briefInfo
  **/
  


  public String getBriefInfo() {
    return briefInfo;
  }

  public void setBriefInfo(String briefInfo) {
    this.briefInfo = briefInfo;
  }

  public ClassRecordDTO afterStatus(String afterStatus) {
    this.afterStatus = afterStatus;
    return this;
  }

  /**
   * Get afterStatus
   * @return afterStatus
  **/
  


  public String getAfterStatus() {
    return afterStatus;
  }

  public void setAfterStatus(String afterStatus) {
    this.afterStatus = afterStatus;
  }

  public ClassRecordDTO review(String review) {
    this.review = review;
    return this;
  }

  /**
   * Get review
   * @return review
  **/
  


  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public ClassRecordDTO coachCheck(String coachCheck) {
    this.coachCheck = coachCheck;
    return this;
  }

  /**
   * Get coachCheck
   * @return coachCheck
  **/
  


  public String getCoachCheck() {
    return coachCheck;
  }

  public void setCoachCheck(String coachCheck) {
    this.coachCheck = coachCheck;
  }

  public ClassRecordDTO userCheck(String userCheck) {
    this.userCheck = userCheck;
    return this;
  }

  /**
   * Get userCheck
   * @return userCheck
  **/
  


  public String getUserCheck() {
    return userCheck;
  }

  public void setUserCheck(String userCheck) {
    this.userCheck = userCheck;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassRecordDTO classRecordDTO = (ClassRecordDTO) o;
    return Objects.equals(this.id, classRecordDTO.id) &&
        Objects.equals(this.userId, classRecordDTO.userId) &&
        Objects.equals(this.creationTime, classRecordDTO.creationTime) &&
        Objects.equals(this.creatorId, classRecordDTO.creatorId) &&
        Objects.equals(this.startTime, classRecordDTO.startTime) &&
        Objects.equals(this.endTime, classRecordDTO.endTime) &&
        Objects.equals(this.target, classRecordDTO.target) &&
        Objects.equals(this.eatStatus, classRecordDTO.eatStatus) &&
        Objects.equals(this.bodyStatus, classRecordDTO.bodyStatus) &&
        Objects.equals(this.sleepStatus, classRecordDTO.sleepStatus) &&
        Objects.equals(this.briefInfo, classRecordDTO.briefInfo) &&
        Objects.equals(this.afterStatus, classRecordDTO.afterStatus) &&
        Objects.equals(this.review, classRecordDTO.review) &&
        Objects.equals(this.coachCheck, classRecordDTO.coachCheck) &&
        Objects.equals(this.userCheck, classRecordDTO.userCheck);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, creationTime, creatorId, startTime, endTime, target, eatStatus, bodyStatus, sleepStatus, briefInfo, afterStatus, review, coachCheck, userCheck);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClassRecordDTO implements Serializable{\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    eatStatus: ").append(toIndentedString(eatStatus)).append("\n");
    sb.append("    bodyStatus: ").append(toIndentedString(bodyStatus)).append("\n");
    sb.append("    sleepStatus: ").append(toIndentedString(sleepStatus)).append("\n");
    sb.append("    briefInfo: ").append(toIndentedString(briefInfo)).append("\n");
    sb.append("    afterStatus: ").append(toIndentedString(afterStatus)).append("\n");
    sb.append("    review: ").append(toIndentedString(review)).append("\n");
    sb.append("    coachCheck: ").append(toIndentedString(coachCheck)).append("\n");
    sb.append("    userCheck: ").append(toIndentedString(userCheck)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


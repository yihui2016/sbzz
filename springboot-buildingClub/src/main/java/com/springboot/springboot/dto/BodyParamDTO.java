package com.springboot.springboot.dto;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;


import org.springframework.validation.annotation.Validated;



/**
 * BodyParamDTO
 */
@Validated


public class BodyParamDTO implements Serializable{
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("creationTime")
  private Long creationTime = null;

  @JsonProperty("creatorId")
  private String creatorId = null;

  @JsonProperty("weight")
  private Integer weight = null;

  @JsonProperty("bust")
  private String bust = null;

  @JsonProperty("waistline")
  private String waistline = null;

  @JsonProperty("hipline")
  private String hipline = null;

  @JsonProperty("leftArm")
  private String leftArm = null;

  @JsonProperty("rightArm")
  private String rightArm = null;

  @JsonProperty("leftThigh")
  private String leftThigh = null;

  @JsonProperty("rightThigh")
  private String rightThigh = null;

  @JsonProperty("extraInfo")
  private String extraInfo = null;

  @JsonProperty("imgUri")
  private String imgUri = null;

  public BodyParamDTO id(String id) {
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

  public BodyParamDTO userId(String userId) {
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

  public BodyParamDTO creationTime(Long creationTime) {
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

  public BodyParamDTO creatorId(String creatorId) {
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

  public BodyParamDTO weight(Integer weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Get weight
   * @return weight
  **/
  


  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public BodyParamDTO bust(String bust) {
    this.bust = bust;
    return this;
  }

  /**
   * Get bust
   * @return bust
  **/
  


  public String getBust() {
    return bust;
  }

  public void setBust(String bust) {
    this.bust = bust;
  }

  public BodyParamDTO waistline(String waistline) {
    this.waistline = waistline;
    return this;
  }

  /**
   * Get waistline
   * @return waistline
  **/
  


  public String getWaistline() {
    return waistline;
  }

  public void setWaistline(String waistline) {
    this.waistline = waistline;
  }

  public BodyParamDTO hipline(String hipline) {
    this.hipline = hipline;
    return this;
  }

  /**
   * Get hipline
   * @return hipline
  **/
  


  public String getHipline() {
    return hipline;
  }

  public void setHipline(String hipline) {
    this.hipline = hipline;
  }

  public BodyParamDTO leftArm(String leftArm) {
    this.leftArm = leftArm;
    return this;
  }

  /**
   * Get leftArm
   * @return leftArm
  **/
  


  public String getLeftArm() {
    return leftArm;
  }

  public void setLeftArm(String leftArm) {
    this.leftArm = leftArm;
  }

  public BodyParamDTO rightArm(String rightArm) {
    this.rightArm = rightArm;
    return this;
  }

  /**
   * Get rightArm
   * @return rightArm
  **/
  


  public String getRightArm() {
    return rightArm;
  }

  public void setRightArm(String rightArm) {
    this.rightArm = rightArm;
  }

  public BodyParamDTO leftThigh(String leftThigh) {
    this.leftThigh = leftThigh;
    return this;
  }

  /**
   * Get leftThigh
   * @return leftThigh
  **/
  


  public String getLeftThigh() {
    return leftThigh;
  }

  public void setLeftThigh(String leftThigh) {
    this.leftThigh = leftThigh;
  }

  public BodyParamDTO rightThigh(String rightThigh) {
    this.rightThigh = rightThigh;
    return this;
  }

  /**
   * Get rightThigh
   * @return rightThigh
  **/
  


  public String getRightThigh() {
    return rightThigh;
  }

  public void setRightThigh(String rightThigh) {
    this.rightThigh = rightThigh;
  }

  public BodyParamDTO extraInfo(String extraInfo) {
    this.extraInfo = extraInfo;
    return this;
  }

  /**
   * Get extraInfo
   * @return extraInfo
  **/
  


  public String getExtraInfo() {
    return extraInfo;
  }

  public void setExtraInfo(String extraInfo) {
    this.extraInfo = extraInfo;
  }

  public BodyParamDTO imgUri(String imgUri) {
    this.imgUri = imgUri;
    return this;
  }

  /**
   * Get imgUri
   * @return imgUri
  **/
  


  public String getImgUri() {
    return imgUri;
  }

  public void setImgUri(String imgUri) {
    this.imgUri = imgUri;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BodyParamDTO bodyParamDTO = (BodyParamDTO) o;
    return Objects.equals(this.id, bodyParamDTO.id) &&
        Objects.equals(this.userId, bodyParamDTO.userId) &&
        Objects.equals(this.creationTime, bodyParamDTO.creationTime) &&
        Objects.equals(this.creatorId, bodyParamDTO.creatorId) &&
        Objects.equals(this.weight, bodyParamDTO.weight) &&
        Objects.equals(this.bust, bodyParamDTO.bust) &&
        Objects.equals(this.waistline, bodyParamDTO.waistline) &&
        Objects.equals(this.hipline, bodyParamDTO.hipline) &&
        Objects.equals(this.leftArm, bodyParamDTO.leftArm) &&
        Objects.equals(this.rightArm, bodyParamDTO.rightArm) &&
        Objects.equals(this.leftThigh, bodyParamDTO.leftThigh) &&
        Objects.equals(this.rightThigh, bodyParamDTO.rightThigh) &&
        Objects.equals(this.extraInfo, bodyParamDTO.extraInfo) &&
        Objects.equals(this.imgUri, bodyParamDTO.imgUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, creationTime, creatorId, weight, bust, waistline, hipline, leftArm, rightArm, leftThigh, rightThigh, extraInfo, imgUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BodyParamDTO implements Serializable{\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    bust: ").append(toIndentedString(bust)).append("\n");
    sb.append("    waistline: ").append(toIndentedString(waistline)).append("\n");
    sb.append("    hipline: ").append(toIndentedString(hipline)).append("\n");
    sb.append("    leftArm: ").append(toIndentedString(leftArm)).append("\n");
    sb.append("    rightArm: ").append(toIndentedString(rightArm)).append("\n");
    sb.append("    leftThigh: ").append(toIndentedString(leftThigh)).append("\n");
    sb.append("    rightThigh: ").append(toIndentedString(rightThigh)).append("\n");
    sb.append("    extraInfo: ").append(toIndentedString(extraInfo)).append("\n");
    sb.append("    imgUri: ").append(toIndentedString(imgUri)).append("\n");
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


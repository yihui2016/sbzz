package com.springboot.springboot.dto;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;


import org.springframework.validation.annotation.Validated;



/**
 * ClassRecordDetailDTO
 */
@Validated


public class ClassRecordDetailDTO implements Serializable{
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("classRecordId")
  private String classRecordId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("strength")
  private String strength = null;

  @JsonProperty("times")
  private String times = null;

  @JsonProperty("round")
  private String round = null;

  @JsonProperty("extraInfo")
  private String extraInfo = null;

  public ClassRecordDetailDTO id(String id) {
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

  public ClassRecordDetailDTO classRecordId(String classRecordId) {
    this.classRecordId = classRecordId;
    return this;
  }

  /**
   * Get classRecordId
   * @return classRecordId
  **/
  


  public String getClassRecordId() {
    return classRecordId;
  }

  public void setClassRecordId(String classRecordId) {
    this.classRecordId = classRecordId;
  }

  public ClassRecordDetailDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ClassRecordDetailDTO strength(String strength) {
    this.strength = strength;
    return this;
  }

  /**
   * Get strength
   * @return strength
  **/
  


  public String getStrength() {
    return strength;
  }

  public void setStrength(String strength) {
    this.strength = strength;
  }

  public ClassRecordDetailDTO times(String times) {
    this.times = times;
    return this;
  }

  /**
   * Get times
   * @return times
  **/
  


  public String getTimes() {
    return times;
  }

  public void setTimes(String times) {
    this.times = times;
  }

  public ClassRecordDetailDTO round(String round) {
    this.round = round;
    return this;
  }

  /**
   * Get round
   * @return round
  **/
  


  public String getRound() {
    return round;
  }

  public void setRound(String round) {
    this.round = round;
  }

  public ClassRecordDetailDTO extraInfo(String extraInfo) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassRecordDetailDTO classRecordDetailDTO = (ClassRecordDetailDTO) o;
    return Objects.equals(this.id, classRecordDetailDTO.id) &&
        Objects.equals(this.classRecordId, classRecordDetailDTO.classRecordId) &&
        Objects.equals(this.name, classRecordDetailDTO.name) &&
        Objects.equals(this.strength, classRecordDetailDTO.strength) &&
        Objects.equals(this.times, classRecordDetailDTO.times) &&
        Objects.equals(this.round, classRecordDetailDTO.round) &&
        Objects.equals(this.extraInfo, classRecordDetailDTO.extraInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, classRecordId, name, strength, times, round, extraInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClassRecordDetailDTO implements Serializable{\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    classRecordId: ").append(toIndentedString(classRecordId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    strength: ").append(toIndentedString(strength)).append("\n");
    sb.append("    times: ").append(toIndentedString(times)).append("\n");
    sb.append("    round: ").append(toIndentedString(round)).append("\n");
    sb.append("    extraInfo: ").append(toIndentedString(extraInfo)).append("\n");
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


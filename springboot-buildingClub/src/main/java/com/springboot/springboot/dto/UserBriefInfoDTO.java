package com.springboot.springboot.dto;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


import org.springframework.validation.annotation.Validated;



/**
 * UserBriefInfoDTO
 */
@Validated



  


public class UserBriefInfoDTO implements Serializable{
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("creationTime")
  private Long creationTime = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("age")
  private String age = null;

  @JsonProperty("job")
  private String job = null;

  @JsonProperty("target")
  private String target = null;

  @JsonProperty("height")
  private String height = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("role")
  private String role = null;

  @JsonProperty("pid")
  private String pid = null;

  @JsonProperty("imgUri")
  private String imgUri = null;

  public UserBriefInfoDTO id(String id) {
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

  public UserBriefInfoDTO creationTime(Long creationTime) {
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

  public UserBriefInfoDTO name(String name) {
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

  public UserBriefInfoDTO age(String age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  **/
  


  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public UserBriefInfoDTO job(String job) {
    this.job = job;
    return this;
  }

  /**
   * Get job
   * @return job
  **/
  


  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public UserBriefInfoDTO target(String target) {
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

  public UserBriefInfoDTO height(String height) {
    this.height = height;
    return this;
  }

  /**
   * Get height
   * @return height
  **/
  


  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public UserBriefInfoDTO phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  **/
  


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public UserBriefInfoDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  **/
  


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserBriefInfoDTO role(String role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
  **/
  


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public UserBriefInfoDTO pid(String pid) {
    this.pid = pid;
    return this;
  }

  /**
   * Get pid
   * @return pid
  **/
  


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }

  public UserBriefInfoDTO imgUri(String imgUri) {
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
    UserBriefInfoDTO userBriefInfoDTO = (UserBriefInfoDTO) o;
    return Objects.equals(this.id, userBriefInfoDTO.id) &&
        Objects.equals(this.creationTime, userBriefInfoDTO.creationTime) &&
        Objects.equals(this.name, userBriefInfoDTO.name) &&
        Objects.equals(this.age, userBriefInfoDTO.age) &&
        Objects.equals(this.job, userBriefInfoDTO.job) &&
        Objects.equals(this.target, userBriefInfoDTO.target) &&
        Objects.equals(this.height, userBriefInfoDTO.height) &&
        Objects.equals(this.phone, userBriefInfoDTO.phone) &&
        Objects.equals(this.password, userBriefInfoDTO.password) &&
        Objects.equals(this.role, userBriefInfoDTO.role) &&
        Objects.equals(this.pid, userBriefInfoDTO.pid) &&
        Objects.equals(this.imgUri, userBriefInfoDTO.imgUri);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, creationTime, name, age, job, target, height, phone, password, role, pid, imgUri);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserBriefInfoDTO implements Serializable{\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    job: ").append(toIndentedString(job)).append("\n");
    sb.append("    target: ").append(toIndentedString(target)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    pid: ").append(toIndentedString(pid)).append("\n");
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


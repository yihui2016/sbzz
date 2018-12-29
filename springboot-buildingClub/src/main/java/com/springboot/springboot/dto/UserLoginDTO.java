package com.springboot.springboot.dto;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;


import org.springframework.validation.annotation.Validated;



/**
 * UserLoginDTO
 */
@Validated


public class UserLoginDTO implements Serializable{
  @JsonProperty("uniqueId")
  private String uniqueId = null;

  @JsonProperty("password")
  private String password = null;

  public UserLoginDTO uniqueId(String uniqueId) {
    this.uniqueId = uniqueId;
    return this;
  }

  /**
   * 电话号码/邮箱地址等唯一标识
   * @return uniqueId
  **/
  


  public String getUniqueId() {
    return uniqueId;
  }

  public void setUniqueId(String uniqueId) {
    this.uniqueId = uniqueId;
  }

  public UserLoginDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * the password of the tenant
   * @return password
  **/
  


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserLoginDTO userLoginDTO = (UserLoginDTO) o;
    return Objects.equals(this.uniqueId, userLoginDTO.uniqueId) &&
        Objects.equals(this.password, userLoginDTO.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uniqueId, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserLoginDTO implements Serializable{\n");
    
    sb.append("    uniqueId: ").append(toIndentedString(uniqueId)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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


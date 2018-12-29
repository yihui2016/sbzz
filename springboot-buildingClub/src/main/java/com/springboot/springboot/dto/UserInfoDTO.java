package com.springboot.springboot.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * UserInfoDTO
 */
@Validated


public class UserInfoDTO extends UserBriefInfoDTO implements Serializable{
  @JsonProperty("bodyParams")
  
  private List<BodyParamDTO> bodyParams = null;

  public UserInfoDTO bodyParams(List<BodyParamDTO> bodyParams) {
    this.bodyParams = bodyParams;
    return this;
  }

  public UserInfoDTO addBodyParamsItem(BodyParamDTO bodyParamsItem) {
    if (this.bodyParams == null) {
      this.bodyParams = new ArrayList<BodyParamDTO>();
    }
    this.bodyParams.add(bodyParamsItem);
    return this;
  }

  /**
   * Get bodyParams
   * @return bodyParams
  **/
  

  

  public List<BodyParamDTO> getBodyParams() {
    return bodyParams;
  }

  public void setBodyParams(List<BodyParamDTO> bodyParams) {
    this.bodyParams = bodyParams;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserInfoDTO userInfoDTO = (UserInfoDTO) o;
    return Objects.equals(this.bodyParams, userInfoDTO.bodyParams) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bodyParams, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfoDTO implements Serializable{\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    bodyParams: ").append(toIndentedString(bodyParams)).append("\n");
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


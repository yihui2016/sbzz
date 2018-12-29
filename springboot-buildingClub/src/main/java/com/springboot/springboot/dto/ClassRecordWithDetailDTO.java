package com.springboot.springboot.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;



/**
 * ClassRecordWithDetailDTO
 */
@Validated


public class ClassRecordWithDetailDTO extends ClassRecordDTO implements Serializable{
  @JsonProperty("details")
  
  private List<ClassRecordDetailDTO> details = null;

  public ClassRecordWithDetailDTO details(List<ClassRecordDetailDTO> details) {
    this.details = details;
    return this;
  }

  public ClassRecordWithDetailDTO addDetailsItem(ClassRecordDetailDTO detailsItem) {
    if (this.details == null) {
      this.details = new ArrayList<ClassRecordDetailDTO>();
    }
    this.details.add(detailsItem);
    return this;
  }

  /**
   * Get details
   * @return details
  **/
  

  

  public List<ClassRecordDetailDTO> getDetails() {
    return details;
  }

  public void setDetails(List<ClassRecordDetailDTO> details) {
    this.details = details;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassRecordWithDetailDTO classRecordWithDetailDTO = (ClassRecordWithDetailDTO) o;
    return Objects.equals(this.details, classRecordWithDetailDTO.details) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(details, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClassRecordWithDetailDTO implements Serializable{\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
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


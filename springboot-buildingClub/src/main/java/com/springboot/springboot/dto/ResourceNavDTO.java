package com.springboot.springboot.dto;
import java.io.Serializable;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


import org.springframework.validation.annotation.Validated;



/**
 * the  navigable resource
 */

@Validated



  


public class ResourceNavDTO implements Serializable{
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("display")
  private String display = null;

  @JsonProperty("resourceUri")
  private String resourceUri = null;

  @JsonProperty("imageUri")
  private String imageUri = null;

  @JsonProperty("creationTime")
  private Long creationTime = null;

  @JsonProperty("category")
  private String category = null;

  public ResourceNavDTO id(String id) {
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

  public ResourceNavDTO display(String display) {
    this.display = display;
    return this;
  }

  /**
   * 要显示的名字（用户名，文章名）
   * @return display
  **/
  


  public String getDisplay() {
    return display;
  }

  public void setDisplay(String display) {
    this.display = display;
  }

  public ResourceNavDTO resourceUri(String resourceUri) {
    this.resourceUri = resourceUri;
    return this;
  }

  /**
   * 资源跳转的Uri，目前基本上没有用到
   * @return resourceUri
  **/
  


  public String getResourceUri() {
    return resourceUri;
  }

  public void setResourceUri(String resourceUri) {
    this.resourceUri = resourceUri;
  }

  public ResourceNavDTO imageUri(String imageUri) {
    this.imageUri = imageUri;
    return this;
  }

  /**
   * 资源相关的图片
   * @return imageUri
  **/
  


  public String getImageUri() {
    return imageUri;
  }

  public void setImageUri(String imageUri) {
    this.imageUri = imageUri;
  }

  public ResourceNavDTO creationTime(Long creationTime) {
    this.creationTime = creationTime;
    return this;
  }

  /**
   * 资源相关的时间
   * @return creationTime
  **/
  


  public Long getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Long creationTime) {
    this.creationTime = creationTime;
  }

  public ResourceNavDTO category(String category) {
    this.category = category;
    return this;
  }

  /**
   * 资源类型
   * @return category
  **/
  


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResourceNavDTO resourceNavDTO = (ResourceNavDTO) o;
    return Objects.equals(this.id, resourceNavDTO.id) &&
        Objects.equals(this.display, resourceNavDTO.display) &&
        Objects.equals(this.resourceUri, resourceNavDTO.resourceUri) &&
        Objects.equals(this.imageUri, resourceNavDTO.imageUri) &&
        Objects.equals(this.creationTime, resourceNavDTO.creationTime) &&
        Objects.equals(this.category, resourceNavDTO.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, display, resourceUri, imageUri, creationTime, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResourceNavDTO implements Serializable{\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    display: ").append(toIndentedString(display)).append("\n");
    sb.append("    resourceUri: ").append(toIndentedString(resourceUri)).append("\n");
    sb.append("    imageUri: ").append(toIndentedString(imageUri)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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


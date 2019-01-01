package com.springboot.springboot.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 分页描述
 */

@Validated

public class ListPagesDTO<T> implements Serializable {
	@JsonProperty("offset")
	private Integer offset = null;

	@JsonProperty("limit")
	private Integer limit = null;

	@JsonProperty("count")
	private Long count = null;

	@JsonProperty("code")
	private String code = null;

	@JsonProperty("message")
	private String message = null;

	@JsonProperty("data")
	private List<T> data = null;

	public ListPagesDTO() {
		this.code = "0";
		this.message = "ok";
	}

	public ListPagesDTO(List<T> data, Long count, Integer offset, Integer limit) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.count = count;
		this.code = "0";
		this.message = "ok";
		this.data = data;
	}

	public ListPagesDTO(Integer offset, Integer limit, Long count, String code, String message, List<T> data) {
		super();
		this.offset = offset;
		this.limit = limit;
		this.count = count;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public ListPagesDTO offset(Integer offset) {
		this.offset = offset;
		return this;
	}

	/**
	 * Get offset
	 * 
	 * @return offset
	 **/

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public ListPagesDTO limit(Integer limit) {
		this.limit = limit;
		return this;
	}

	/**
	 * Get limit
	 * 
	 * @return limit
	 **/

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public ListPagesDTO count(Long count) {
		this.count = count;
		return this;
	}

	/**
	 * Get count
	 * 
	 * @return count
	 **/

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ListPagesDTO pageDescDTO = (ListPagesDTO) o;
		return Objects.equals(this.offset, pageDescDTO.offset) && Objects.equals(this.limit, pageDescDTO.limit)
				&& Objects.equals(this.count, pageDescDTO.count);
	}

	@Override
	public int hashCode() {
		return Objects.hash(offset, limit, count);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PageDescDTO implements Serializable{\n");

		sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
		sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
		sb.append("    count: ").append(toIndentedString(count)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    data: ").append(toIndentedString(data)).append("\n");

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

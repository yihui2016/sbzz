package com.springboot.springboot.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.springboot.constant.ErrorCodeEnum;

public class ResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = 1090472154290152467L;

    @JsonProperty("code")
    protected String code = null;

    @JsonProperty("message")
    private String message = null;

    @JsonProperty("data")
    private T data = null;

    public ResponseDTO() {
        this.code(ErrorCodeEnum.SUCCESS.getCode());
        this.message(ErrorCodeEnum.SUCCESS.getMessage());
    }

    public ResponseDTO(T data) {
    	this.code(ErrorCodeEnum.SUCCESS.getCode());
    	this.message(ErrorCodeEnum.SUCCESS.getMessage());
    	this.data(data);
    }

	public ResponseDTO(T data, String message) {
		this.code(ErrorCodeEnum.SUCCESS.getCode());
		this.message(message);
		this.data(data);
	}

    public ResponseDTO(String code, String message) {
    	this.code(code);
    	this.message(message);
    }

    public ResponseDTO(T data, ErrorCodeEnum codeConstant) {
    	this.code(codeConstant.getCode());
    	this.data(data);
    	this.message(codeConstant.getMessage());
    }

    public ResponseDTO(ErrorCodeEnum codeConstant) {
    	this.code(codeConstant.getCode());
    	this.message(codeConstant.getMessage());
    }

    public static Boolean isSuccess(ResponseDTO returnWithCode) {
        return ErrorCodeEnum.SUCCESS.getCode().equals(returnWithCode.getCode());
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public void code(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void message(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public void data(T data) {
		this.data = data;
	}
    
}

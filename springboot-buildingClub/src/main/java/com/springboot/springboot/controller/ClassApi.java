package com.springboot.springboot.controller;

import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.springboot.dto.*;
import com.springboot.springboot.security.UserSession;

public interface ClassApi {

	// 创建用户日期课程
	@RequestMapping(value = "/c/user/{id}/class/rocord", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Object> cUserIdClassRecordPost(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @RequestBody ClassRecordWithDetailDTO data, @UserSession SessionDTO session);

	// 获取用户课程列表大纲
	@RequestMapping(value = "/c/user/{id}/class/rocords", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Object> cUserIdClassRecordsGet(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "limit", required = false) Integer limit, @UserSession SessionDTO session);

	// 获取课程详情
	@RequestMapping(value = "/c/class/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Object> cClassIdGet(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @UserSession SessionDTO session);

	// 修改课程信息
	@RequestMapping(value = "/c/class/{id}", produces = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Object> cClassIdPut(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @RequestBody ClassRecordWithDetailDTO data, @UserSession SessionDTO session);

}

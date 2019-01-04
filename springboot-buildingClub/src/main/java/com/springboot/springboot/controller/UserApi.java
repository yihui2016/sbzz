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

public interface UserApi {

	// 登陆
	@RequestMapping(value = "/u/users/login", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Object> uUsersLoginPost(@RequestBody UserLoginDTO data,
			@RequestParam(value = "requestTime", required = true) long requestTime);

	// 创建用户
	@RequestMapping(value = "/u/user", produces = { "application/json" }, method = RequestMethod.POST)
	ResponseEntity<Object> uUserPost(@NotNull @RequestParam(value = "token", required = true) String token,
			@RequestBody UserInfoDTO data, @UserSession SessionDTO session);

	// 获取用户列表
	@RequestMapping(value = "/u/users", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Object> uUsersGet(@NotNull @RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "limit", required = false) Integer limit, @UserSession SessionDTO session);

	// 获取详情
	@RequestMapping(value = "/u/user/{id}", produces = { "application/json" }, method = RequestMethod.GET)
	ResponseEntity<Object> uUserIdGet(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @UserSession SessionDTO session);

	// 修改用户信息
	@RequestMapping(value = "/u/user/{id}", produces = { "application/json" }, method = RequestMethod.PUT)
	ResponseEntity<Object> uUserIdPut(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @RequestBody UserInfoDTO data, @UserSession SessionDTO session);

	// 删除用户
	@RequestMapping(value = "/u/user/{id}", produces = { "application/json" }, method = RequestMethod.DELETE)
	ResponseEntity<Object> uUserIdDelete(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @PathVariable("newId") String newId, @UserSession SessionDTO session);

}

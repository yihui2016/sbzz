package com.springboot.springboot.controller.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.constant.ErrorCodeEnum;
import com.springboot.springboot.controller.UserApi;
import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.ResponseDTO;
import com.springboot.springboot.dto.SessionDTO;
import com.springboot.springboot.dto.UserInfoDTO;
import com.springboot.springboot.dto.UserLoginDTO;
import com.springboot.springboot.security.UserSession;
import com.springboot.springboot.service.UserService;
import com.springboot.springboot.util.CommonUtil;

@RestController
@EnableScheduling
public class UserApiController implements UserApi {
	@Autowired
	UserService userService;
	
	@RequestMapping("/hello")
	public String helloWorld() {
		return "spring boot helloWorld";
	}
	
	@RequestMapping("/users")
	public List<User> listUsers(@NotNull @RequestParam(value = "token", required = true) String token,
			@UserSession SessionDTO session) {
		return userService.listUsers();
	}

	@Override
	public ResponseEntity<Object> uUsersLoginPost(@RequestBody UserLoginDTO data,
			@RequestParam(value = "requestTime", required = true) long requestTime) {
		if (data == null || CommonUtil.isNullOrEmpty(data.getUniqueId()) || CommonUtil.isNullOrEmpty(data.getPassword())) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.PARAMETER_WRONG), HttpStatus.OK);
		}
		ResponseDTO<SessionDTO> r = userService.userLogin(data, requestTime);
		return new ResponseEntity<Object>(r, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> uUserPost(UserInfoDTO data, long requestTime) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

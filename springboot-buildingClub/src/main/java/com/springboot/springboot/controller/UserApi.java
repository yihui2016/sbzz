package com.springboot.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.springboot.dto.*;

public interface UserApi {
	
    @RequestMapping(value = "/u/users/login", produces = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<Object> uUsersLoginPost(@RequestBody UserLoginDTO data,
                                           @RequestParam(value = "requestTime", required = true) long requestTime);

    @RequestMapping(value = "/u/user", produces = {"application/json"}, method = RequestMethod.POST)
    ResponseEntity<Object> uUserPost(@RequestBody UserInfoDTO data,
                                           @RequestParam(value = "requestTime", required = true) long requestTime);

}

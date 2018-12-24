package com.springboot.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.service.UserService;

@RestController
@EnableScheduling
public class Controller {
	@Autowired
	UserService userService;
	
	@RequestMapping("/hello")
	public String helloWorld() {
		return "spring boot helloWorld";
	}
	
	@RequestMapping("/users")
	public List<User> listUsers() {
		return userService.listUsers();
	}
}

package com.springboot.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.springboot.dao.model.User;

public interface UserService {
	
	List<User> listUsers();
	
}

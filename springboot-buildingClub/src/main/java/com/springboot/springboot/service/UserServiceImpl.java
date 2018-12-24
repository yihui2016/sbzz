package com.springboot.springboot.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springboot.dao.mapper.UserMapper;
import com.springboot.springboot.dao.model.User;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	@Resource
	UserMapper userMapper;

	@Override
	public List<User> listUsers() {
		return userMapper.selectAllUser();
	}
}

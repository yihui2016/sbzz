package com.springboot.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.ResponseDTO;
import com.springboot.springboot.dto.SessionDTO;
import com.springboot.springboot.dto.UserLoginDTO;

public interface UserService {
	
	List<User> listUsers();
	
	int deleteById(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    // 用户登录
	ResponseDTO<SessionDTO> userLogin(UserLoginDTO data, long requestTime);
}

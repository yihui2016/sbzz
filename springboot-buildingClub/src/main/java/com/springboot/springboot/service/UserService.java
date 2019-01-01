package com.springboot.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.ListPagesDTO;
import com.springboot.springboot.dto.ResponseDTO;
import com.springboot.springboot.dto.SessionDTO;
import com.springboot.springboot.dto.UserInfoDTO;
import com.springboot.springboot.dto.UserLoginDTO;

public interface UserService {
	
	List<User> listUsers();
	
//	int deleteById(String id);
//
//    int insertSelective(User record);
//
//    User selectByPrimaryKey(String id);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);

    // 用户登录
	ResponseDTO<SessionDTO> userLogin(UserLoginDTO data, long requestTime);
	
	// 创建用户
	ResponseDTO<String> createUser(UserInfoDTO data, SessionDTO session);

	// 检查手机号是否创建过用户
	ResponseDTO<Long> getByPhone(String phone, SessionDTO session);

	// 检查手机号是否创建过用户
	ResponseDTO<UserInfoDTO> getById(String id, SessionDTO session);

	ListPagesDTO<UserInfoDTO> listUsersByPid(SessionDTO session, Integer offset, Integer limit);

	ListPagesDTO<UserInfoDTO> listUsers(SessionDTO session, Integer offset, Integer limit);

	ResponseDTO<String> updateUser(UserInfoDTO data, String id, SessionDTO session);

}

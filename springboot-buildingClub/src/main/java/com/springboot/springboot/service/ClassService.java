package com.springboot.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.ClassRecordDTO;
import com.springboot.springboot.dto.ClassRecordWithDetailDTO;
import com.springboot.springboot.dto.ListPagesDTO;
import com.springboot.springboot.dto.ResponseDTO;
import com.springboot.springboot.dto.SessionDTO;
import com.springboot.springboot.dto.UserInfoDTO;
import com.springboot.springboot.dto.UserLoginDTO;

public interface ClassService {

	// 创建用户
	ResponseDTO<String> createClass(String userId, ClassRecordWithDetailDTO data, SessionDTO session);

	// 查询用户课程大纲
	ListPagesDTO<ClassRecordDTO> listClassRecords(SessionDTO session, String userId, Integer offset, Integer limit);

	// 查询用户课程大纲
	ResponseDTO<ClassRecordWithDetailDTO> getClassRecord(SessionDTO session, String id);

//	// 检查手机号是否创建过用户
//	ResponseDTO<Long> getByPhone(String phone, SessionDTO session);
//
//	// 检查手机号是否创建过用户
//	ResponseDTO<UserInfoDTO> getById(String id, SessionDTO session);
//
//	ListPagesDTO<UserInfoDTO> listUsersByPid(SessionDTO session, Integer offset, Integer limit);
//
//
//	ResponseDTO<String> updateUser(UserInfoDTO data, String id, SessionDTO session);
}

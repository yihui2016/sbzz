package com.springboot.springboot.service;

import com.springboot.springboot.dto.ClassRecordDTO;
import com.springboot.springboot.dto.ClassRecordDetailDTO;
import com.springboot.springboot.dto.ClassRecordWithDetailDTO;
import com.springboot.springboot.dto.ListPagesDTO;
import com.springboot.springboot.dto.ResponseDTO;
import com.springboot.springboot.dto.SessionDTO;

public interface ClassService {

	// 创建用户
	ResponseDTO<String> createClass(String userId, ClassRecordWithDetailDTO data, SessionDTO session);

	// 查询用户课程大纲
	ListPagesDTO<ClassRecordDTO> listClassRecords(SessionDTO session, String userId, Integer offset, Integer limit);

	// 查询用户课程大纲
	ResponseDTO<ClassRecordWithDetailDTO> getClassRecord(SessionDTO session, String id);

	ResponseDTO<String> updateClass(ClassRecordWithDetailDTO data, String id, SessionDTO session);
	
	ResponseDTO<String> deleteClass(String id, SessionDTO session);

	ResponseDTO<ClassRecordDetailDTO> getClassRecordDetail(SessionDTO session, String id);

	ResponseDTO<String> deleteClassRecordDetail(String id, SessionDTO session);

}

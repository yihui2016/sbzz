package com.springboot.springboot.controller.impl;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.constant.AuthorityValue;
import com.springboot.springboot.constant.ErrorCodeEnum;
import com.springboot.springboot.controller.ClassApi;
import com.springboot.springboot.dto.ClassRecordDTO;
import com.springboot.springboot.dto.ClassRecordWithDetailDTO;
import com.springboot.springboot.dto.ListPagesDTO;
import com.springboot.springboot.dto.ResponseDTO;
import com.springboot.springboot.dto.SessionDTO;
import com.springboot.springboot.dto.UserInfoDTO;
import com.springboot.springboot.security.UserSession;
import com.springboot.springboot.service.ClassService;
import com.springboot.springboot.service.UserService;
import com.springboot.springboot.util.CommonUtil;

@RestController
@EnableScheduling
public class ClassApiController implements ClassApi {

	@Autowired
	ClassService classService;
	@Autowired
	UserService userService;

	@Override
	public ResponseEntity<Object> cUserIdClassRecordPost(
			@NotNull @RequestParam(value = "token", required = true) String token, @PathVariable("id") String id,
			@RequestBody ClassRecordWithDetailDTO data, @UserSession SessionDTO session) {
		long nowTime = System.currentTimeMillis();
		if (CommonUtil.isNullOrEmpty(id) || data == null || data.getStartTime() == null || data.getEndTime() == null
				|| data.getEndTime() <= data.getStartTime() || data.getStartTime() < nowTime
				|| data.getEndTime() < nowTime) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.PARAMETER_WRONG), HttpStatus.OK);
		}
		boolean checkRole = checkRole(id, session);
		if (!checkRole) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.NOT_FOUND), HttpStatus.OK);
		}

		ResponseDTO<String> r = classService.createClass(id, data, session);
		return new ResponseEntity<Object>(r, HttpStatus.OK);
	}

	private boolean checkRole(String id, SessionDTO session) {
		if (AuthorityValue.ROLE9.equals(session.getRole()) || AuthorityValue.ROLE7.equals(session.getRole())) {
			return true;
		}
		UserInfoDTO user = userService.getById(id, session).getData();
		// 教练只能给自己旗下的学员做操作
		if (user == null || !session.getUserId().equals(user.getPid())) {
			return false;
		}
		return true;
	}

	@Override
	public ResponseEntity<Object> cUserIdClassRecordsGet(
			@NotNull @RequestParam(value = "token", required = true) String token, @PathVariable("id") String id,
			@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "limit", required = false) Integer limit, @UserSession SessionDTO session) {
		if (CommonUtil.isNullOrEmpty(id)) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.PARAMETER_WRONG), HttpStatus.OK);
		}

		boolean checkRole = checkRole(id, session);
		if (!checkRole) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.NOT_FOUND), HttpStatus.OK);
		}

		if (offset == null || limit == null) {
			offset = 0;
			limit = 6;
		}

		ListPagesDTO<ClassRecordDTO> r = classService.listClassRecords(session, id, offset, limit);
		return new ResponseEntity<Object>(r, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> cClassIdGet(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @UserSession SessionDTO session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> cClassIdPut(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @RequestBody ClassRecordWithDetailDTO data,
			@UserSession SessionDTO session) {
		// TODO Auto-generated method stub
		return null;
	}

}

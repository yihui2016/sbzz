package com.springboot.springboot.controller.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.constant.AuthorityValue;
import com.springboot.springboot.constant.ErrorCodeEnum;
import com.springboot.springboot.controller.UserApi;
import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.ListPagesDTO;
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
		if (data == null || CommonUtil.isNullOrEmpty(data.getUniqueId())
				|| CommonUtil.isNullOrEmpty(data.getPassword())) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.PARAMETER_WRONG), HttpStatus.OK);
		}
		ResponseDTO<SessionDTO> r = userService.userLogin(data, requestTime);
		return new ResponseEntity<Object>(r, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> uUserPost(@NotNull @RequestParam(value = "token", required = true) String token,
			@RequestBody UserInfoDTO data, @UserSession SessionDTO session) {
		if (data == null || CommonUtil.isNullOrEmpty(data.getName()) || CommonUtil.isNullOrEmpty(data.getPhone())
				|| CommonUtil.isNullOrEmpty(data.getPassword())) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.PARAMETER_WRONG), HttpStatus.OK);
		}
		System.out.println(session);
		if (AuthorityValue.ROLE9.equals(session.getRole())) {
			data.setRole(AuthorityValue.ROLE7);
		} else if (AuthorityValue.ROLE7.equals(session.getRole())) {
			// 店长新建教练
			data.setRole(AuthorityValue.ROLE5);
		} else if (AuthorityValue.ROLE5.equals(session.getRole())) {
			// 教练创建学员
			data.setRole(AuthorityValue.ROLE1);
		} else {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.NO_ROLE), HttpStatus.OK);
		}
		// 检查手机号是否存在
		ResponseDTO<Long> byPhone = userService.getByPhone(data.getPhone(), session);
		if (byPhone.getData() != null) {
			return new ResponseEntity<Object>(byPhone, HttpStatus.OK);
		}
		// 新建
		ResponseDTO<String> r = userService.createUser(data, session);
		return new ResponseEntity<Object>(r, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> uUsersGet(@NotNull @RequestParam(value = "token", required = true) String token,
			@RequestParam(value = "offset", required = false) Integer offset,
			@RequestParam(value = "limit", required = false) Integer limit, @UserSession SessionDTO session) {
		if(offset == null || limit == null){
			offset = 0;
			limit =6;
		}
		if(AuthorityValue.ROLE5.equals(session.getRole())){
			ListPagesDTO<UserInfoDTO> r = userService.listUsersByPid(session, offset, limit);
			return new ResponseEntity<Object>(r, HttpStatus.OK);
		}else if (AuthorityValue.ROLE7.equals(session.getRole()) || AuthorityValue.ROLE9.equals(session.getRole())){
			ListPagesDTO<UserInfoDTO> r = userService.listUsers(session, offset, limit);
			return new ResponseEntity<Object>(r, HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.NO_ROLE), HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<Object> uUserIdGet(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @UserSession SessionDTO session) {
		if (CommonUtil.isNullOrEmpty(id)){
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.PARAMETER_WRONG), HttpStatus.OK);
		}

		ResponseDTO<UserInfoDTO> r = userService.getById(id, session);
		return new ResponseEntity<Object>(r, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> uUserIdPut(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @RequestBody UserInfoDTO data, @UserSession SessionDTO session) {
		if (CommonUtil.isNullOrEmpty(id) || data == null || !AuthorityValue.ROLE5.equals(session.getRole())
				|| !AuthorityValue.ROLE7.equals(session.getRole()) || !AuthorityValue.ROLE9.equals(session.getRole())) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.PARAMETER_WRONG), HttpStatus.OK);
		}

		UserInfoDTO user = userService.getById(id, session).getData();
		if (user == null || !AuthorityValue.ROLE1.equals(user.getRole())) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.NOT_FOUND), HttpStatus.OK);
		}

		ResponseDTO<String> r = userService.updateUser(data, id, session);
		return new ResponseEntity<Object>(r, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> uUserIdDelete(@NotNull @RequestParam(value = "token", required = true) String token,
			@PathVariable("id") String id, @PathVariable("newId") String newId, @UserSession SessionDTO session) {
		if (CommonUtil.isNullOrEmpty(id)) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.PARAMETER_WRONG), HttpStatus.OK);
		}
		// 只有店长才能删除 且删除的只能是role5 的
		if (!AuthorityValue.ROLE7.equals(session.getRole()) && !AuthorityValue.ROLE9.equals(session.getRole())) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.NO_ROLE), HttpStatus.OK);
		}

		UserInfoDTO user = userService.getById(id, session).getData();
		if (user == null || !AuthorityValue.ROLE5.equals(user.getRole()) || !AuthorityValue.ROLE1.equals(user.getRole())) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.NOT_FOUND), HttpStatus.OK);
		}
		
		if (AuthorityValue.ROLE5.equals(user.getRole()) && (CommonUtil.isNullOrEmpty(newId) || id.equals(newId))) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.PARAMETER_WRONG), HttpStatus.OK);
		}
		
		UserInfoDTO toUser = userService.getById(newId, session).getData();
		if (toUser == null || !AuthorityValue.ROLE5.equals(toUser.getRole())) {
			return new ResponseEntity<Object>(new ResponseDTO<>(ErrorCodeEnum.NOT_FOUND), HttpStatus.OK);
		}

		ResponseDTO<String> r = userService.deleteUser(session, id, newId);
		return new ResponseEntity<Object>(r, HttpStatus.OK);
	}

}

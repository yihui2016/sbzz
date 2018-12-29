package com.springboot.springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springboot.constant.ErrorCodeEnum;
import com.springboot.springboot.dao.mapper.UserMapper;
import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.ResponseDTO;
import com.springboot.springboot.dto.SessionDTO;
import com.springboot.springboot.dto.UserLoginDTO;
import com.springboot.springboot.service.UserService;
import com.springboot.springboot.util.CommonUtil;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	UserMapper userMapper;
	@Autowired
	SessionBiz sessionBiz;

	@Override
	public ResponseDTO<SessionDTO> userLogin(UserLoginDTO data, long requestTime) {
		User user = userMapper.selectByPhone(data.getUniqueId());
		if (user == null) {
			return new ResponseDTO<>(ErrorCodeEnum.LOGIN_ACCOUNT_ERROR);
		}

		String md5 = CommonUtil.getMD5(user.getPassword() + requestTime);
		if (!md5.equals(data.getPassword())) {
			return new ResponseDTO<>(ErrorCodeEnum.LOGIN_PASSWORD_ERROR);
		}
		// 验证通过
		String token = CommonUtil.getGenerateUUID();
		logger.info("userLogin token" + token);
		SessionDTO buildSession = sessionBiz.buildSession(token, user, 0L);
		return new ResponseDTO<>(buildSession);
	}

	@Override
	public List<User> listUsers() {
		return userMapper.listUsers();
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

}

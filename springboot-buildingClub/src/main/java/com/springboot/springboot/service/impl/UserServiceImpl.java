package com.springboot.springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.springboot.springboot.constant.ErrorCodeEnum;
import com.springboot.springboot.dao.mapper.BodyParamMapper;
import com.springboot.springboot.dao.mapper.UserMapper;
import com.springboot.springboot.dao.model.BodyParam;
import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.BodyParamDTO;
import com.springboot.springboot.dto.ListPagesDTO;
import com.springboot.springboot.dto.ResponseDTO;
import com.springboot.springboot.dto.SessionDTO;
import com.springboot.springboot.dto.UserInfoDTO;
import com.springboot.springboot.dto.UserLoginDTO;
import com.springboot.springboot.dto.helper.UserDtoHelper;
import com.springboot.springboot.service.UserService;
import com.springboot.springboot.util.CommonUtil;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Resource
	UserMapper userMapper;
	@Resource
	BodyParamMapper bodyParamMapper;
	@Autowired
	SessionBiz sessionBiz;
	@Autowired
	UserDtoHelper helper;

	@Override
	public List<User> listUsers() {
		return userMapper.listUsers();
	}

	@Override
	public ResponseDTO<SessionDTO> userLogin(UserLoginDTO data, long requestTime) {
		User user = userMapper.selectByPhone(data.getUniqueId());
		if (user == null) {
			return new ResponseDTO<>(ErrorCodeEnum.LOGIN_ACCOUNT_ERROR);
		}

		String md5 = CommonUtil.getMD5(user.getPassword() + requestTime);
		if (!user.getPassword().equals(data.getPassword())) {
			System.out.println(md5);
			System.out.println(data.getPassword());
			return new ResponseDTO<>(ErrorCodeEnum.LOGIN_PASSWORD_ERROR);
		}
		// 验证通过
		String token = CommonUtil.getGenerateUUID();
		logger.info("userLogin token" + token);
		SessionDTO buildSession = sessionBiz.buildSession(token, user, 0L);
		return new ResponseDTO<>(buildSession);
	}

	@Override
	public ResponseDTO<String> createUser(UserInfoDTO data, SessionDTO session) {
		User model = helper.toModel(data);
		String id = CommonUtil.getGenerateUUID();
		model.setId(id);
		model.setPid(session.getUserId());
		model.setCreationTime(System.currentTimeMillis());
		model.setDeleteFlag(false);
		
		userMapper.insertSelective(model);

		addBodyParam(data, id, session);

		return new ResponseDTO<>(id);
	}

	@Override
	public ResponseDTO<Long> getByPhone(String phone, SessionDTO session) {
		User user = userMapper.selectByPhone(phone);
		if (user == null) {
			return new ResponseDTO<>();
		}
		return new ResponseDTO<>(user.getCreationTime(), ErrorCodeEnum.RESOURCE_EXISTED);
	}

	@Override
	public ResponseDTO<UserInfoDTO> getById(String id, SessionDTO session) {
		User user = userMapper.selectByPrimaryKey(id);
		if (user == null) {
			return new ResponseDTO<>(ErrorCodeEnum.NOT_FOUND);
		}
		UserInfoDTO r = helper.toDto(user);

		List<BodyParam> bodyParams = bodyParamMapper.selectByUserId(id);
		List<BodyParamDTO> bodyParamDtos = helper.toBodyParamDtos(bodyParams);
		r.setBodyParams(bodyParamDtos);

		return new ResponseDTO<>(r);
	}

	@Override
	public ListPagesDTO<UserInfoDTO> listUsersByPid(SessionDTO session, Integer offset, Integer limit) {
		List<User> users = userMapper.selectByPid(session.getUserId(), offset, limit);
		long count = userMapper.countByPid(session.getUserId());

		List<UserInfoDTO> data = helper.toDtos(users);
		ListPagesDTO<UserInfoDTO> r = new ListPagesDTO<>(data, count, offset, limit);
		return r;
	}

	@Override
	public ListPagesDTO<UserInfoDTO> listUsers(SessionDTO session, Integer offset, Integer limit) {
		List<User> users = userMapper.selectAll(offset, limit);
		long count = userMapper.countAll();

		List<UserInfoDTO> data = helper.toDtos(users);
		ListPagesDTO<UserInfoDTO> r = new ListPagesDTO<>(data, count, offset, limit);
		return r;
	}

	@Override
	public ResponseDTO<String> updateUser(UserInfoDTO data, String id, SessionDTO session) {
		User user = userMapper.selectByPrimaryKey(id);
		if (user == null) {
			return new ResponseDTO<>(ErrorCodeEnum.NOT_FOUND);
		}

		addBodyParam(data, id, session);
		return new ResponseDTO<>(id);
	}

	private void addBodyParam(UserInfoDTO data, String id, SessionDTO session) {
		List<BodyParamDTO> bodyParams = data.getBodyParams();
		if(bodyParams == null || bodyParams.isEmpty()) {
			return;
		}
		for (BodyParamDTO dto : bodyParams) {
			BodyParam bodyParam = helper.toBodyParamModel(dto);
			if (CommonUtil.isNullOrEmpty(dto.getId())) {
				bodyParam.setId(CommonUtil.getGenerateUUID());
				bodyParam.setCreationTime(System.currentTimeMillis());
				bodyParam.setCreatorId(session.getUserId());
				bodyParam.setUserId(id);
				// 测量参数只能添加新的
				bodyParamMapper.insert(bodyParam);
			}
		}
	}

	@Async
	@Override
	public ResponseDTO<String> deleteUser(SessionDTO session, String id, String newId) {
		userMapper.deleteByPrimaryKey(id);
		List<User> selectAllByPid = userMapper.selectAllByPid(id);
		for (User user : selectAllByPid) {
			User record = new User();
			StringBuilder sb = new StringBuilder();
			sb.append(user.getExtraInfo());
			sb.append("  at[");
			sb.append(System.currentTimeMillis());
			sb.append("]user[");
			sb.append(session);
			sb.append("]upd pid from ");
			sb.append(user.getPid());
			sb.append(" to ");
			sb.append(newId);
			String extraInfo = sb.toString();

			record.setId(user.getId());
			record.setExtraInfo(extraInfo);
			record.setPid(newId);
			userMapper.updateByPrimaryKeySelective(record);
		}
		return new ResponseDTO<>(newId);
	}

}

package com.springboot.springboot.service.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.springboot.springboot.constant.Constant;
import com.springboot.springboot.dao.model.User;
import com.springboot.springboot.dto.SessionDTO;

@Component
public class SessionBiz {
	private static final Logger logger = LoggerFactory.getLogger(SessionBiz.class);

	@Autowired
	RedisTemplate<String, String> redisTemplate;

	public void addToken2Redis(String token, SessionDTO user, Long timeoutHours) {
		String jsonSession = JSON.toJSONString(user);
		System.out.println("add token userId" + user.getUserId());
		logger.info("addToken2Redis" + token);
		redisTemplate.opsForValue().set(Constant.TOKEN + token, jsonSession, 1, TimeUnit.HOURS);
	}

	public void removeByToken(String token) {
		redisTemplate.delete(Constant.TOKEN + token);
	}

	public SessionDTO buildSession(String token, User user, Long timeoutHours) {
		SessionDTO d = new SessionDTO();
		d.setUserId(user.getId());
		d.setRole(user.getRole());
		d.setpId(user.getPid());
		d.setToken(token);
		d.setName(user.getName());
		addToken2Redis(token, d, timeoutHours);
		return d;
	}

	public SessionDTO getSession(String token) {
		SessionDTO session = null;
		String jsonSession = redisTemplate.opsForValue().get(Constant.TOKEN + token);
		if (jsonSession == null) {
			return session;
		}
		// 增加token过期时间?? 效果待观察
		redisTemplate.opsForValue().set(Constant.TOKEN + token, jsonSession, 1, TimeUnit.HOURS);

		session = JSON.parseObject(jsonSession, SessionDTO.class);
		return session;
	}

}

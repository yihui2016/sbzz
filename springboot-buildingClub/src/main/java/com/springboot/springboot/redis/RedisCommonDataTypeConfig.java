package com.springboot.springboot.redis;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisCommonDataTypeConfig  {
	
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(cf);
		return redisTemplate;
	}
	
	@Bean
	public RedisTemplate<String, Long> redisCounterTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Long> template = new RedisTemplate<String, Long>();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericToStringSerializer<Long>(Long.class));
		return template;
	}
	
	@Bean
	public RedisTemplate<String, List<Integer>> redisTemplateHashMap(RedisConnectionFactory cf) {
		RedisTemplate<String, List<Integer>> redisTemplate = new RedisTemplate<String, List<Integer>>();
		redisTemplate.setConnectionFactory(cf);
		return redisTemplate;
	}
}

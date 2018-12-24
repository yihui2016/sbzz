package com.springboot.springboot.redis;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisSetTest {
//    @Autowired
    static RedisTemplate redisTemplate;
    private static void init() {
    	JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
		redisConnectionFactory.setHostName("127.0.0.1");
		redisConnectionFactory.setPort(6379);
		redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
    }
    
    public static void main(String[] args) {
    	init();
    	
    	BoundSetOperations<String,String> boundSetOps = redisTemplate.boundSetOps("333333");
		if(boundSetOps.size() < 1) {
			
		}
		
//		return boundSetOps.members();
    }
    

}

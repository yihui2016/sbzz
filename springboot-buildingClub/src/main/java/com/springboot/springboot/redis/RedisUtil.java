package com.springboot.springboot.redis;

import java.util.Collections;
import java.util.concurrent.TimeoutException;

import org.joda.time.DateTime;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
@Service
public class RedisUtil {
    private static JedisPool pool = null;
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    public static JedisPool getPool() {
        if (pool != null) return pool;
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(500);
        config.setMaxIdle(10);
        config.setMaxWaitMillis(10 * 1000);
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "127.0.0.1", 6379, 10 * 1000);
        return pool;
    }
    
    public synchronized Jedis getResource() {
		if (pool == null)
			pool = getPool();
		return pool.getResource();
	}
    
    public static StringRedisTemplate initRedisTemplate() {
    	StringRedisTemplate redisTemplate = new StringRedisTemplate();
		return redisTemplate;
    }
    
    public Boolean tryGetDistributedLock(String lockKey, String requestId, Long expireTime)
			throws TimeoutException, InterruptedException {
		Long startPoint = DateTime.now().getMillis();
		while (true) {
			if (DateTime.now().getMillis() - startPoint >= expireTime) {
				throw new TimeoutException("获取超时");
			} else {
				Jedis resource = null;
				try {
					resource = getResource();
					String result = resource.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, 5000L);
					if (LOCK_SUCCESS.equals(result)) {
						System.out.println(requestId + "  accept Lock");
						return true;
					}
					Thread.sleep(500);
				} finally {
					if (resource != null) {
						resource.close();
					}
				}
			}
		}
	}

    public Boolean releaseDistributedLock(String lockKey, String requestId) {
		Jedis resource = null;
		try {
			String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
			resource = getResource();
			Object result = resource.eval(script, Collections.singletonList(lockKey),
					Collections.singletonList(requestId));
			if (RELEASE_SUCCESS.equals(result)) {
				System.out.println(requestId + "  release lock");
				return true;
			}
			return false;
		} finally {
			if (resource != null) {
				resource.close();
			}
		}
	}
}

package com.springboot.springboot.redis;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisTest {
    @Autowired
    RedisUtil redisUtil;
//     redisTemplate;

//    public Long add(String key, String value) {
//        return redisTemplate.opsForSet().add(key, value);
//    }
//
//    public Long addWithTime(String key, String value, Long expiretime) {
//    	redisTemplate.expire(key, expiretime, TimeUnit.MILLISECONDS);
//    	return redisTemplate.opsForSet().add(key, value);
//    }
//    
//    public Set<String> getValues(String key) {
//        return redisTemplate.boundSetOps(key).members();
//    }
    public static void main(String[] args) {
//    	Jedis jedis = getPool().getResource();
//    	jedis.set("key0", "121");
    	
//    	m1();
    	m2();
    	
	}

	private static void m1() {
		// 锁测试
    	ExecutorService pool = Executors.newScheduledThreadPool(4);
        GenerateCouponTicketsThread thread = new GenerateCouponTicketsThread();
        pool.submit(thread);
        
        ExecutorService pool2 = Executors.newScheduledThreadPool(4);
        pool2.submit(thread);
	}
	
	private static void m2() {
		// 测试释放锁
    	ExecutorService pool = Executors.newScheduledThreadPool(4);
    	GenerateCouponTicketsThread2 thread = new GenerateCouponTicketsThread2();
        pool.submit(thread);
	}

}
class GenerateCouponTicketsThread implements Runnable {

//	@Autowired
    RedisUtil redisUtil;
//	private RedisUtil redisUtil = null;
	public GenerateCouponTicketsThread() {
		redisUtil = new RedisUtil();
	}

	public GenerateCouponTicketsThread(RedisUtil redisUtil) {
//		this.redisUtil = redisUtil;
		this.redisUtil = new RedisUtil();
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
//			System.out.println("redisUtil" + redisUtil);
			testLock("2018-9-12");
			System.out.print("--------------" + i );
		}
	}
	
	public void testLock(String orderId) {
		boolean lock = false;
		String requestId = UUID.randomUUID().toString();
		try {
			lock = redisUtil.tryGetDistributedLock("cancleOrderReturnBackPoint" + orderId, requestId, 4500L);
			if (lock) {
				System.out.print("拿到锁啦~~~~~~~~~~~~~~~~~~~" + System.currentTimeMillis());
				Thread.sleep(2000);
			}else {
				System.out.print("---------没拿到锁----------" + System.currentTimeMillis());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lock) {
				redisUtil.releaseDistributedLock("cancleOrderReturnBackPoint" + orderId, requestId);
			}
		}
	}
}
class GenerateCouponTicketsThread2 implements Runnable {

//	@Autowired
    RedisUtil redisUtil;
//	private RedisUtil redisUtil = null;
	public GenerateCouponTicketsThread2() {
		redisUtil = new RedisUtil();
	}

	public GenerateCouponTicketsThread2(RedisUtil redisUtil) {
//		this.redisUtil = redisUtil;
		this.redisUtil = new RedisUtil();
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			testLock("2018-9-12");
			System.out.println("-------for1-------" + i );
		}
		try {
			Thread.sleep(5000L);
		} catch (Exception e) {
		}
		for (int i = 0; i < 3; i++) {
			testLock("2018-9-12");
			System.out.println("--------for2------" + i );
		}
	}
	
	public void testLock(String orderId) {
		boolean lock = false;
		String requestId = UUID.randomUUID().toString();
		try {
			lock = redisUtil.tryGetDistributedLock("cancleOrderReturnBackPoint" + orderId, requestId, 500L);
			if (lock) {
				System.out.print("拿到锁啦~~~~~~~~~~~~~~~~~~~" + System.currentTimeMillis());
				Thread.sleep(2000);
			}else {
				System.out.print("---------没拿到锁----------" + System.currentTimeMillis());
			}
		} catch (Exception e) {
			System.out.println(" timeout");
//			e.printStackTrace();
		} finally {
//			if (lock) {
//				redisUtil.releaseDistributedLock("cancleOrderReturnBackPoint" + orderId, requestId);
//			}
		}
	}
}

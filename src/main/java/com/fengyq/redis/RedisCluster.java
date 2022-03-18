package com.fengyq.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

import java.util.HashMap;
import java.util.Map;

public class RedisCluster {

    public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("redis.xml");
//		RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
//		String lockKey="str1";
//		String value=UUID.randomUUID().toString();
//		value=null;
//		redisTemplate.delete(lockKey);
//		redisTemplate.opsForValue().set(lockKey,value);
//		System.out.println(redisTemplate.opsForValue().get(lockKey));
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JedisCluster jedisCluster = (JedisCluster) context.getBean("jedisCluster");
		
		String strKey="tbproduct:inter_prd_code:001_JXTJ1801:prd_name";
		String strValue="吉祥添金1801";
		jedisCluster.del(strKey);
		jedisCluster.set(strKey,strValue);
		System.out.println(jedisCluster.get(strKey));
		System.out.println();
		
		String hashKey="tbproduct:inter_prd_code:001_JXTJ1801";
		HashMap<String, String> hashValue=new HashMap<String, String>();
		hashValue.put("prd_code","JXTJ1801");
		hashValue.put("prd_name","吉祥添金1801");
		hashValue.put("guest_rate","4.4%");
		jedisCluster.del(hashKey);
		jedisCluster.hmset(hashKey, hashValue);
		System.out.println(jedisCluster.hmget(hashKey, "prd_code","prd_name","guest_rate"));
		System.out.println();
		
		String setKey="tbunitstock:combi_no:001_jxtj1801:inter_code";
		String setKey2="tbunitstock:combi_no:001_jxtj1802:inter_code";
		String setKey3="tbunitstock:combi_no:001_jxtj1803:inter_code";
		jedisCluster.del(setKey);
		jedisCluster.del(setKey2);
		jedisCluster.del(setKey3);
		jedisCluster.sadd(setKey, "180205.IB_YH","180210.IB_YH");
		jedisCluster.sadd(setKey2, "180205.IB_YH","170210.IB_YH");
		jedisCluster.sadd(setKey3, "180205.IB_YH","170205.IB_YH");
		System.out.println(jedisCluster.smembers(setKey));
		System.out.println();
		
		String zsetKey="tbhisprdassetdetail:combi_no:001_jxtj1801:inter_code:asset_value";
		Map<String, Double> memberToScore=new HashMap<String, Double>();
		memberToScore.put("180205.IB_YH", 1001.00);
		memberToScore.put("180210.IB_YH", 1002.00);
		jedisCluster.del(zsetKey);
		jedisCluster.zadd(zsetKey, memberToScore);
		System.out.println(jedisCluster.zrevrange(zsetKey, 0, -1));
		System.out.println();
		
		String listKey="tbinstext:deal_serial_no";
		jedisCluster.del(listKey);
		jedisCluster.lpush(listKey, "20191027001","20191027002");
		System.out.println(jedisCluster.lpop(listKey));
		System.out.println();

		/*jedisCluster.del(strKey);
		jedisCluster.del(hashKey);
		jedisCluster.del(setKey);
		jedisCluster.del(setKey2);
		jedisCluster.del(setKey3);
		jedisCluster.del(zsetKey);
		jedisCluster.del(listKey);*/
//		JedisPoolConfig poolConfig = new JedisPoolConfig();
//	    // 最大连接数
//	    poolConfig.setMaxTotal(1);
//	    // 最大空闲数
//	    poolConfig.setMaxIdle(1);
//	    // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
//	    // Could not get a resource from the pool
//	    poolConfig.setMaxWaitMillis(1000);
//	    Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
//	    nodes.add(new HostAndPort("192.168.175.23", 7001));
//	    nodes.add(new HostAndPort("192.168.175.23", 7002));
//	    nodes.add(new HostAndPort("192.168.175.23", 7003));
//	    nodes.add(new HostAndPort("192.168.175.23", 7004));
//	    nodes.add(new HostAndPort("192.168.175.23", 7005));
//	    nodes.add(new HostAndPort("192.168.175.23", 7006));
//	    JedisCluster cluster = new JedisCluster(nodes, poolConfig);
//	    String name = cluster.get("name");
//	    System.out.println(name);
//	    cluster.set("age", "18");
//	    System.out.println(cluster.get("age"));
//	    try {
//	        cluster.close();
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
		
//		JedisPoolConfig poolConfig = new JedisPoolConfig();
//	    // 最大连接数
//	    poolConfig.setMaxTotal(2);
//	    // 最大空闲数
//	    poolConfig.setMaxIdle(2);
//	    // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
//	    // Could not get a resource from the pool
//	    poolConfig.setMaxWaitMillis(1000);
//	    JedisPool pool = new JedisPool(poolConfig, "192.168.175.23", 6379);
//	    Jedis jedis = null;
//	    try {
//	        for (int i = 0; i < 5; i++) {
//	            jedis = pool.getResource();
//	            jedis.set("foo" + i, "bar" + i);
//	            System.out.println("第" + (i + 1) + "个连接, 得到的值为" + jedis.get("foo" + i));
//	            // 用完一定要释放连接
//	            jedis.close();
//	        }
//	    } finally {
//	        pool.close();
//	    }
	}
}

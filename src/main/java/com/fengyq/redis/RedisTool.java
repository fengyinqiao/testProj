package com.fengyq.redis;

import redis.clients.jedis.JedisCluster;

import java.util.Collections;

public class RedisTool {
    private static final String LOCK_SUCCESS="OK";
    private static final String SET_IF_NOT_EXIST="NX";
    private static final String SET_WITH_EXPIRE_TIME="PX";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     *尝试获取分布式锁
     * @param jedisCluster redis客户端
     * @param lockKey 锁key
     * @param requestId 请求标识
     * @param expireTime 超时时间
     * @return 锁是否获取成功
     */
    public static boolean tryGetDistributedLock(JedisCluster jedisCluster,String lockKey,String requestId,int expireTime) {
        String res=jedisCluster.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if(LOCK_SUCCESS.equals(res)) {
            return true;
        }
        return false;
    }

    /**
     *释放分布式锁
     * @param jedisCluster redis客户端
     * @param lockKey 锁key
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(JedisCluster jedisCluster,String lockKey,String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedisCluster.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}

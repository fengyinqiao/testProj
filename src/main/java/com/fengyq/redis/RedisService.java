package com.fengyq.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RedisService {
    static JedisCluster jedisCluster;
    static HashMap hashMap;
    static {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jedisCluster = (JedisCluster) context.getBean("jedisCluster");
        hashMap=new HashMap();
        hashMap.put("001_JXTJ1801", "吉祥添金1801");
        hashMap.put("001_JXTJ1802", "吉祥添金1802");
        hashMap.put("001_JXTJ1803", "吉祥添金1803");
        jedisCluster.del("001_JXTJ1801");
        jedisCluster.del("001_JXTJ1802");
        jedisCluster.del("001_JXTJ1803");
        jedisCluster.del("001_JXTJ1804");
    }

    public static void main(String[] args) {
        Runnable task=new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"获取结果："+getData("001_JXTJ1801"));//测试缓存击穿
                    //System.out.println(Thread.currentThread().getName()+"获取结果："+getData("001_JXTJ1804"));//测试缓存穿透
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ExecutorService executorService= Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.submit(task);
        }
        executorService.shutdown();
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"获取结果："+getData("001_JXTJ1801"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"获取结果："+getData("001_JXTJ1801"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"获取结果："+getData("001_JXTJ1801"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程3").start();*/
    }

    /**
     * 获取数据，可防止缓存击穿
     * @param key
     * @return
     * @throws InterruptedException
     */
    public static Object getData(String key) throws InterruptedException {
        //从缓存中取，缓存命中直接返回
        String res=(String)getDataFromRedis(key);
        if(res==null) {
            String lockKey=key+":lock";
            String requestId=UUID.randomUUID().toString();
            //缓存为空，先尝试获取分布式锁
            if(RedisTool.tryGetDistributedLock(jedisCluster,lockKey,requestId,10000)) {
                try {
                    System.out.println(Thread.currentThread().getName()+"获取锁，锁key："+lockKey+"，锁value："+requestId);
                    //获取锁成功，操作数据库
                    System.out.println(Thread.currentThread().getName()+"查询数据库，key："+key);
                    res=(String)getDataFromDB(key);
                    System.out.println(Thread.currentThread().getName()+"查询数据库结果，key："+key+"，value："+res);
                    System.out.println(Thread.currentThread().getName()+"设置缓存，key："+key+"，value："+res);
                    setDataToRedis(key, res);
                } finally {
                    boolean releaseResult=RedisTool.releaseDistributedLock(jedisCluster, lockKey, requestId);
                    if(releaseResult) {
                        System.out.println(Thread.currentThread().getName()+"释放锁，锁key："+lockKey+"，锁value："+requestId);
                    }
                }
            }else {
                //获取锁失败，休眠100ms，再尝试获取数据
                System.out.println(Thread.currentThread().getName()+"获取锁失败，休眠100ms");
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+"休眠100ms后，重新获取数据");
                return getData(key);
            }
        }
        return res;
    }

    /**
     * 模拟从数据库中取数据
     * @param key
     * @return
     */
    private static Object getDataFromDB(String key){
        return hashMap.get(key);
    }

    /**
     * 从缓存中取数据
     * @param key
     * @return
     */
    private static Object getDataFromRedis(String key){
        return jedisCluster.get(key);
    }

    /**
     * 用数据库中取到的结果，设置缓存
     * @param key
     * @param result
     */
    private static void setDataToRedis(String key,String result){
        if(result!=null) {
            //设置随机超时时间，防止缓存雪崩
            if(result.equals("吉祥添金1801")) {
                //模拟热门商品，设置长的超时时间
                Random random=new Random();
                long expireTime=3600+random.nextInt(3600);//60分钟+随机超时时间
                jedisCluster.set(key, result, "NX", "EX", expireTime);
            }else {
                //模拟冷门商品，设置短的超时时间
                Random random=new Random();
                long expireTime=600+random.nextInt(600);//10分钟+随机超时时间
                jedisCluster.set(key, result, "NX", "EX", expireTime);
            }
        }else {
            //缓存空value，防止缓存穿透
            jedisCluster.set(key, " ", "NX", "EX", 60);
        }
    }
}

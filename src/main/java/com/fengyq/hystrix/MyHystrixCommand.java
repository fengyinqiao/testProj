package com.fengyq.hystrix;

import com.netflix.hystrix.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class MyHystrixCommand extends HystrixCommand<Integer>{
    static class OrderServiceProvider  {
        private final static Logger logger = LoggerFactory.getLogger(OrderServiceProvider.class);
        private AtomicInteger OrderIdCounter = new AtomicInteger(0);

        public Integer queryByOrderId() {
            int c = OrderIdCounter.getAndIncrement();
            if (logger.isDebugEnabled()) {
                logger.debug("OrderIdCounter:{}", c);
            }
            if (c < 11) {
                try {
                    Thread.sleep(600);
                } catch (InterruptedException e) {
                }
                //throw new RuntimeException();
            }
            return c;
        }

        public void reset() {
            OrderIdCounter.getAndSet(0);
        }
    }

    private final static Logger logger = LoggerFactory.getLogger(MyHystrixCommand.class);
    private OrderServiceProvider orderServiceProvider;

    public MyHystrixCommand(OrderServiceProvider orderServiceProvider) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("orderService"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("queryByOrderId"))
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withCircuitBreakerEnabled(true)//默认是true，本例中为了展现该参数
                                .withCircuitBreakerForceOpen(false)//默认是false，本例中为了展现该参数
                                .withCircuitBreakerForceClosed(false)//默认是false，本例中为了展现该参数
                                .withCircuitBreakerErrorThresholdPercentage(50)//(1)错误百分比超过50%（默认50%）
                                .withCircuitBreakerRequestVolumeThreshold(10)//(2)10s以内调用次数10次（默认20次），同时满足(1)(2)熔断器打开
                                .withCircuitBreakerSleepWindowInMilliseconds(5000)//熔断器中断请求5秒（默认5秒）后会进入半打开状态,放部分流量过去重试
                                .withExecutionTimeoutEnabled(true)
                                .withExecutionTimeoutInMilliseconds(500)
                                //以下是信号量隔离的配置
                                //.withExecutionIsolationStrategy(ExecutionIsolationStrategy.SEMAPHORE)
                                //.withExecutionIsolationSemaphoreMaxConcurrentRequests(1)//最大并发请求量,限流参数
                )
                .andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                            //.withMaxQueueSize(10)   //配置队列大小
                            .withCoreSize(10)    // 配置线程池里的线程数
                )
        );
        this.orderServiceProvider = orderServiceProvider;
    }

    protected Integer run() {
        return orderServiceProvider.queryByOrderId();
    }

    protected Integer getFallback() {
        return -1;
    }


    public static class UnitTest {
        static OrderServiceProvider orderServiceProvider=new OrderServiceProvider();
        @Test
        public void testMyHystrixCommand() {
            Integer r = new MyHystrixCommand(orderServiceProvider).execute();
            logger.info("result:{}", r);
        }

        @Test
        public void testExecuteCommand() throws InterruptedException {
            orderServiceProvider.reset();
            int i = 1;
            for (; i < 15; i++) {
                HystrixCommand<Integer> command = new MyHystrixCommand(orderServiceProvider);
                Integer r = command.execute();
                String method = r == -1 ? "fallback" : "run";
                logger.info("call {} times,result:{},method:{},isCircuitBreakerOpen:{}", i, r, method, command.isCircuitBreakerOpen());
            }
            //等待6s，使得熔断器进入半打开状态
            Thread.sleep(6000);
            for (; i < 20; i++) {
                HystrixCommand<Integer> command = new MyHystrixCommand(orderServiceProvider);
                Integer r = command.execute();
                String method = r == -1 ? "fallback" : "run";
                logger.info("call {} times,result:{},method:{},isCircuitBreakerOpen:{}", i, r, method, command.isCircuitBreakerOpen());
            }
        }
    }
}

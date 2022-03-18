package com.fengyq.spring;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Aspect
public class AspectTest {

	@Pointcut(value="execution(* com.fengyq.spring.*.hello(..)) && args(param)", argNames = "param")
	public void beforePointcut(String param) {} 
	
	@Before(value="beforePointcut(param)", argNames = "param")
	public void beforeAdvice(String param) {  
		System.out.println("===========before advice param:" + param);  
	}
	

	@AfterThrowing(value="execution(* com.fengyq.spring.*.*(..))",throwing = "exception")
	/*,argNames="exception",throwing = "exception"*/
	public void afterThrowingAdvice(Throwable exception)  {
		try {
			System.out.println("===========after throwing advice exception:" + exception);  
			int[] a={1};
	    	int b=a[2];
		} catch (Exception e) {
			e.printStackTrace();
			//throw e;
		}
	}
	
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.start();
    	IHelloWorldService helloWorldService = (IHelloWorldService) context.getBean("helloWorldService");
		System.out.println("是否是代理调用，AopUtils.isAopProxy(helloWorldService) : " + AopUtils.isAopProxy(helloWorldService));
		System.out.println("是否是cglib类代理调用，AopUtils.isCglibProxy(helloWorldService) : " + AopUtils.isCglibProxy(helloWorldService));
		System.out.println("是否是jdk动态接口代理调用，AopUtils.isJdkDynamicProxy(helloWorldService) : "+ AopUtils.isJdkDynamicProxy(helloWorldService));
		//Bean的使用
    	/*helloWorldService.hello("helloWorldService");*/
		System.in.read();
	}
}

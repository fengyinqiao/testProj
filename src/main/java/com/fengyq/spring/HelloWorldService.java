package com.fengyq.spring;

import org.springframework.aop.framework.AopContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HelloWorldService implements IHelloWorldService{
	public void hello(String param) throws IOException {
		System.out.println("hello:"+param);
		int i=1/0;
//		throw new IOException("hello's ioexception");
	}
	
	public void hello2(String param) throws IOException {
		System.out.println("hello2:"+param);
		HelloWorldService h=((HelloWorldService) AopContext.currentProxy());
		h.hello("AopContext:"+param);
		
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	HelloWorldService helloWorldService = (HelloWorldService) context.getBean("helloWorldService");
    	helloWorldService.hello("ClassPathXmlApplicationContext:"+param);
    	
    	System.out.println(h.equals(helloWorldService));
//		hello(param);
	}
}

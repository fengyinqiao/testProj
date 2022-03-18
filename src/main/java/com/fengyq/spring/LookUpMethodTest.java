package com.fengyq.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LookUpMethodTest implements ApplicationContextAware{
	ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}
	public com.fengyq.spring.LookUpBean getNewestBean() {
//		return (LookUpBean) applicationContext.getBean("LookUpBean");
		return null;//不论方法体如何编写，最终都会被代理的方法覆盖，代理返回<lookup-method name="getNewestBean" bean="LookUpBean"/>标签指定的bean
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		LookUpMethodTest LookUpMethodTest = (LookUpMethodTest) context.getBean("LookUpMethodTest");
    	//Bean的使用
		System.out.println(LookUpMethodTest.getNewestBean());
		System.out.println(LookUpMethodTest.getNewestBean());
	}
}

package com.fengyq.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: MySpringBean
 * @Description: my spring bean to test
 * @author: daniel.zhao
 * @date: 2018年10月26日 上午10:12:37
 */
public class MySpringBean implements BeanNameAware, BeanFactoryAware, InitializingBean, ApplicationContextAware,DisposableBean{

    private ApplicationContext applicationContext;
    private String name;

    public MySpringBean() {
    	System.out.println("Default Constructor:new MySpringBean......");
    }
    public MySpringBean(String name) {
    	this.name=name;
    	System.out.println("ConstructorArg-"+name+" new MySpringBean......");
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("ApplicationContextAware-setApplicationContext......");
        this.applicationContext = context;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean-afterPropertiesSet......");
    }

    @Override
    public void setBeanFactory(BeanFactory bf) throws BeansException {
        System.out.println("BeanFactoryAware-setBeanFactory......");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware-setBeanName......");
    }

    public void initMethod() {
        System.out.println("init-method......");
    }
    
    public void destroyMethod() {
    	System.out.println("destroy-method......");
    }
    
    @Override
	public void destroy() throws Exception {
    	System.out.println("DisposableBean-destroy......");
	}
    
    private void use() {
    	System.out.println("Use Bean:" + this+"......");		
	}
    
    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("SpringContext.xml");
    	MySpringBean mySpringBean = (MySpringBean) context.getBean("MySpringBean");
		//Bean的使用
		mySpringBean.use();
		//关闭容器
		((AbstractApplicationContext) context).close();
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setter-"+name+"......");
	}


	
}
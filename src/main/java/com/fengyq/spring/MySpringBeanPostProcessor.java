package com.fengyq.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MySpringBeanPostProcessor
 * @author: daniel.zhao
 * @date: 2018年10月26日 上午10:40:21
 */
@Component
public class MySpringBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MySpringBean) {
        	System.out.println("BeanPostProcessor-postProcessAfterInitialization......");
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MySpringBean) {
        	System.out.println("BeanPostProcessor-postProcessBeforeInitialization......");
        }
        return bean;
    }

}
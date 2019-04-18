package com.java.handson.spring_basics3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPostProcessorImp implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(" BeanPostProcessorImp : postProcess Before Initialization @@@ " + beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(" BeanPostProcessorImp : postProcess After Initialization @@@ " + beanName);
		return bean;
	}

}

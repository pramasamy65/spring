package com.java.handson.spring_basics2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Messenger implements ApplicationContextAware, BeanNameAware {

	private MessageService messageService;

	public Messenger() {

	}

	public Messenger(MessageService messageService) {
		super();
		System.out.println("Messenger constructor called");
		this.messageService = messageService;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void messageProcessing() {

		messageService.sendMessage();
	}

	// What is Need for Using ApplicationContextAware in Application
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("ApplicationContextAware ::: applicationContext");

	}

	public void setBeanName(String beanName) {
		System.out.println("BeanNameAware ::: setBeanName - Bean Name " + beanName);

	}
}

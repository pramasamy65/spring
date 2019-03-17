package com.java.handson.spring_basics2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class EmailMessageService implements MessageService, InitializingBean, DisposableBean {
	
	public EmailMessageService() {
		System.out.println("EmailMessageService constructor Calling");
	}

	public void sendMessage() {
		System.out.println("Sending Message using Email Service");

	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("EmailMessageService : InitializingBean : :: afterPropertiesSet()");
		
	}
	
	public void destroy() throws Exception {
		System.out.println("EmailMessageService : DisposableBean ::: destroy()");
		
	}

}

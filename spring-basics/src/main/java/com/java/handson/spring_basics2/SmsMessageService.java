package com.java.handson.spring_basics2;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SmsMessageService implements MessageService, DisposableBean, InitializingBean {

	public void sendMessage() {
		System.out.println("Sending Message using SMS Service");

	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("SmsMessageService : InitializingBean : :: afterPropertiesSet()");

	}

	public void destroy() throws Exception {
		System.out.println("SmsMessageService : DisposableBean ::: destroy()");

	}

}

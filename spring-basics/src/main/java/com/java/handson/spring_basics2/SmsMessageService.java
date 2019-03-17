package com.java.handson.spring_basics2;

import org.springframework.beans.factory.DisposableBean;

public class SmsMessageService implements MessageService, DisposableBean{

	public void sendMessage() {
		System.out.println("Sending Message using SMS Service");

	}

	public void destroy() throws Exception {
		System.out.println("SmsMessageService : DisposableBean ::: destroy()");
		
	}

}

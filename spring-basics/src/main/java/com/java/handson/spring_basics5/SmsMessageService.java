package com.java.handson.spring_basics5;

import org.springframework.stereotype.Component;

@Component
public class SmsMessageService implements MessageService{

	public void sendMessage() {
		System.out.println("SmsMessageService : Sending Message using SMS Service");

	}

	public SmsMessageService() {
		System.out.println("SmsMessageService : Constructor Callling");
	}

}

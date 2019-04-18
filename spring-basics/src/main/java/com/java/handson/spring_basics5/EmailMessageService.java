package com.java.handson.spring_basics5;

import org.springframework.stereotype.Service;

@Service
public class EmailMessageService implements MessageService {

	public EmailMessageService() {
		System.out.println("EmailMessageService constructor Calling");
	}

	public void sendMessage() {
		System.out.println("Sending Message using Email Service");

	}

}

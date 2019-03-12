package com.java.handson.spring_basics1;

public class SmsMessageService implements MessageService {

	public void sendMessage(String receiverDetails) {
		System.out.println("Sending SMS to " + receiverDetails);

	}

}

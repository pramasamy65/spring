package com.java.handson.spring_basics1;

public class EmailMessageService implements MessageService {

	public void sendMessage(String receiverDetails) {
		System.out.println("Sending Email to " + receiverDetails);

	}

}

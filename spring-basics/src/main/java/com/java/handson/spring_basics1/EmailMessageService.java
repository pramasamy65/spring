package com.java.handson.spring_basics1;

public class EmailMessageService implements MessageService {
	
	public EmailMessageService() {
		System.out.println("EmailMessageService constructor Calling");
	}

	public void sendMessage(String receiverDetails) {
		System.out.println("Sending Email to " + receiverDetails);

	}

}

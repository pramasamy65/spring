package com.java.handson.spring_basics4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Messenger {

	@Autowired
	@Qualifier("EmailMessageService")
	private MessageService messService;

	private String message;

	public Messenger() {
		System.out.println("Messenger constructor Calling");
	}

	public Messenger(MessageService messageService) {
		super();
		System.out.println("Messenger constructor called");
		this.messService = messageService;
	}

	@Required
	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessService(MessageService messService) {
		this.messService = messService;
	}

	public void messageProcessing() {
		System.out.println("@@@@ : " + message);
		messService.sendMessage();
	}

}

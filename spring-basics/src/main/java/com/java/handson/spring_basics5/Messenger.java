package com.java.handson.spring_basics5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Messenger {

	@Autowired
	@Qualifier("emailMessageService")
	private MessageService messService;
	
	@Autowired
	private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Messenger() {
		System.out.println("Messenger constructor Calling");
	}

	public Messenger(MessageService messageService) {
		super();
		System.out.println("Messenger constructor called");
		this.messService = messageService;
	}

	public void setMessService(MessageService messService) {
		this.messService = messService;
	}

	public void messageProcessing() {
		System.out.println("##### Accessing messageSource from : Bean " + messageSource.getMessage("greeting", null, "HI... I am Default", null));
		messService.sendMessage();
		
		System.out.println("##### Accessing messageSource from : Bean " + messageSource.getMessage("printNames", new Object[] {"Don of Beans"}, "HI... I am Default", null));
	}

}

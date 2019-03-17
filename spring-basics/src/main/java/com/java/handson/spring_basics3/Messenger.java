package com.java.handson.spring_basics3;

public class Messenger {

	private MessageService messService;

	public Messenger() {
		System.out.println("Messenger constructor Calling");
	}

	public Messenger(MessageService messageService) {
		super();
		System.out.println("Messenger constructor called");
		this.messService = messageService;
	}

	public MessageService getMessService() {
		return messService;
	}

	public void setMessService(MessageService messService) {
		this.messService = messService;
	}

	public void messageProcessing() {
		messService.sendMessage();
	}

}

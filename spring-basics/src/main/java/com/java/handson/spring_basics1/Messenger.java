package com.java.handson.spring_basics1;

public class Messenger {

	private MessageService service;

	public MessageService getService() {
		return service;
	}

	public void setService(MessageService service) {
		this.service = service;
	}

	public void messageProcessing() {
		service.sendMessage("Steve Jobs");
	}

}

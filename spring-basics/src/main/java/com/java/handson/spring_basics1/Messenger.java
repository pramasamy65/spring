package com.java.handson.spring_basics1;

public class Messenger {

	String message;
	private String receiverDetails;
	private MessageService service;

	public Messenger(String message, MessageService service) {
		System.out.println("Messenger 2 Args Constructor");
		this.message = message;
		this.service = service;
	}

	public MessageService getService() {
		return service;
	}

	public void setService(MessageService service) {
		System.out.println("Setter Injection");
		this.service = service;
	}

	public String getReceiverDetails() {
		return receiverDetails;
	}

	public void setReceiverDetails(String receiverDetails) {
		this.receiverDetails = receiverDetails;
	}

	public void messageProcessing() {
		System.out.println("Message : " + message);
		service.sendMessage(receiverDetails);
	}

}

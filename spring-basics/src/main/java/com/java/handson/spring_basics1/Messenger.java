package com.java.handson.spring_basics1;

public class Messenger {

	private MessageService service;

	public MessageService getService() {
		return service;
	}

	public void setService(MessageService service) {
		this.service = service;
	}

	private String receiverDetails;


	public void messageProcessing() {
		service.sendMessage(receiverDetails);
	}

	public String getReceiverDetails() {
		return receiverDetails;
	}

	public void setReceiverDetails(String receiverDetails) {
		this.receiverDetails = receiverDetails;
	}

}

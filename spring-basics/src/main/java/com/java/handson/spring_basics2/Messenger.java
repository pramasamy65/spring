package com.java.handson.spring_basics2;

import java.util.List;

public class Messenger {

	private List<MessageService> MessageService;

	public void messageProcessing() {

		for (MessageService service : MessageService) {
			service.sendMessage();
		}
	}

}

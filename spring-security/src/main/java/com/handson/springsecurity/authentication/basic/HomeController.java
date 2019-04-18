package com.handson.springsecurity.authentication.basic;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class HomeController {
	@GetMapping
	public MessageDetails getMessage(@RequestHeader HttpHeaders headers,
			@RequestHeader("Authorization") String authorization) {
		System.out.println("Headers Found..." + headers);
		System.out.println("Authorization Header..." + authorization);
		MessageDetails messageDetails = new MessageDetails("Authentication Success");
		return messageDetails;
	}
}

class MessageDetails {
	String message;

	public MessageDetails(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

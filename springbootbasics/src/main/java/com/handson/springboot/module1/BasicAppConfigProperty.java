package com.handson.springboot.module1;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("initial")
public class BasicAppConfigProperty {
	
	public BasicAppConfigProperty() {
		System.out.println("BasicConfiguration Object Created");
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	private int counter;

}

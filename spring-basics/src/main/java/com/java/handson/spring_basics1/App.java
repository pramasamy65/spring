package com.java.handson.spring_basics1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String args[]) {

		// Normal way of Injecting Dependency

		// Messenger messangerObj = new Messenger();
		// messangerObj.setService(new SmsMessageService());

		// Implementing using Spring
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config1.xml");
		Messenger messangerObj = (Messenger) context.getBean("messenger");
		messangerObj.messageProcessing();
	}

}

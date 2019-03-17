package com.java.handson.spring_basics3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String args[]) {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config3.xml");
		Messenger messangerObj = (Messenger) context.getBean("messengerObj");
		messangerObj.messageProcessing();
	}

}

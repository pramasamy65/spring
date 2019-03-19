package com.java.handson.spring_basics4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String args[]) {
		System.out.println("App 4 Starts");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config4.xml");
		Messenger messangerObj = (Messenger) context.getBean("messengerObj");
		messangerObj.messageProcessing();
	}

}

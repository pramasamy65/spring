package com.java.handson.spring_basics5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String args[]) {
		System.out.println("App 4 Starts");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config5.xml");

		Messenger messangerObj = (Messenger) context.getBean("messenger");
		messangerObj.messageProcessing();

		String greetingStr = context.getMessage("greeting", null, "HI... I am Default", null);
		System.out.println("###### " + greetingStr);
	}

}

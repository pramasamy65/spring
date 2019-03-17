package com.java.handson.spring_basics2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String args[]) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config2.xml");
		context.registerShutdownHook();
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring-config2.xml");
		Messenger messangerObj = (Messenger) context.getBean("messenger");
		messangerObj.messageProcessing();
	}

}

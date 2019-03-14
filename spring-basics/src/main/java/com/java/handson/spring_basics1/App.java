package com.java.handson.spring_basics1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String args[]) {

		// STEP 1 : Normal way of Injecting Dependency

		// Messenger messangerObj = new Messenger();
		// messangerObj.setService(new SmsMessageService());

		// STEP 2 : Implementing using Spring - Bean Factory container
		BeanFactory context = new XmlBeanFactory(new FileSystemResource("spring-config1.xml"));

		// STEP 3 : Implementing using Spring - Application Context Container

		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("spring-config1.xml");
		Messenger messangerObj = (Messenger) context.getBean("messenger");
		messangerObj.messageProcessing();
	}

}

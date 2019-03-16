package com.java.handson.spring_basics2;

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

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config2.xml");
		Messenger messangerObj = (Messenger) context.getBean("messenger");
		messangerObj.messageProcessing();
	}

}

package com.handson.springboot.module1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CommandLineRunnerImpl2 implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private BasicAppConfigProperty applicationProperties;
	
	@Override
	public void run(String... args) throws Exception {
		Arrays.stream(context.getBeanDefinitionNames()).forEach(s -> System.out.println(s));
		Employee emp = (Employee) context.getBean("getemployee");
		System.out.println("@@@@@ Name " + emp.getName());
		System.out.println("Reading from Applicaiton Properties");

		System.out.println("Counter ####  " + applicationProperties.getCounter());
		System.out.println("Message ####  " + applicationProperties.getMessage());
	}

}

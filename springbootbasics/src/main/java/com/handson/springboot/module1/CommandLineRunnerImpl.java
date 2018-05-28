package com.handson.springboot.module1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CommandLineRunnerImpl implements CommandLineRunner {

	@Autowired
	private BasicAppConfigProperty applicationProperties;
	

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Order 2 Counter ####  " + applicationProperties.getCounter());
		System.out.println("Order 2 Message ####  " + applicationProperties.getMessage());
	}
}

package com.handson.springboot.module2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	@Qualifier("employee1")
	private Employee emp;

	@Override
	public void run(String... args) throws Exception {
		Arrays.stream(context.getBeanDefinitionNames()).forEach(name->System.out.println(name));
		//Employee emp = (Employee) context.getBean("employee");
		System.out.println(emp.getName() + " Object " + emp);
	}
}

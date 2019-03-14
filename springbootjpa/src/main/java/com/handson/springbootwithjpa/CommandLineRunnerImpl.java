package com.handson.springbootwithjpa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

	@Autowired
	ApplicationContext context;

	@Override
	public void run(String... args) throws Exception {
		Arrays.asList(context.getBeanDefinitionNames()).stream().forEach(x -> System.out.println(x));

		DetailsController details = (DetailsController) context.getBean("detailsController");
		details.persistanceRepoCall();
	}

}

package com.handson.springbootwithhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

	@Autowired
	DetailsDaoImpl daoImpl;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Run......");
		Account account = new Account(34567, "Savings", "8904");
		Customer customerDetails = new Customer(9876455, "Test-1", 94086, account);
		daoImpl.saveCustomerDetails(customerDetails);
	}

}

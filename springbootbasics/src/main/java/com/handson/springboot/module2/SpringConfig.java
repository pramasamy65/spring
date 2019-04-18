package com.handson.springboot.module2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean("employee1")
	public Employee getemployee1() {
		Employee emp = new Employee();
		emp.setName("Employee 1");
		return emp;
	}

	@Bean("employee2")
	public Employee getemployee2() {
		Employee emp = new Employee();
		emp.setName("Employee 2");
		return emp;
	}

}

package com.handson.springboot.module1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean
	public Employee getemployee() {
		Employee emp = new Employee();
		emp.setName("Ram");
		return emp;
	}

}

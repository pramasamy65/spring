package com.handson.springboot.module2;

import org.springframework.stereotype.Component;

@Component("employee")
public class Employee {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

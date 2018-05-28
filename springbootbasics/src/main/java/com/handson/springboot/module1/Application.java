package com.handson.springboot.module1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("@SpringBootApplication Starts.....");
		SpringApplication.run(Application.class, args);
		System.out.println("@SpringBootApplication main ends.....");
	}

}

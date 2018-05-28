package com.handson.springboot.module2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationModule2 {

	public static void main(String[] args) {
		System.out.println("@SpringBootApplication1 Starts1.....");
		SpringApplication.run(ApplicationModule2.class, args);
		System.out.println("@SpringBootApplication1 main ends.....");
	}

}

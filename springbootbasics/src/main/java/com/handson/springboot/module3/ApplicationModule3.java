package com.handson.springboot.module3;

/**
 * http://localhost:8080/topics
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationModule3 {

	public static void main(String[] args) {
		System.out.println("@SpringBootApplication1 Starts1.....");
		SpringApplication.run(ApplicationModule3.class, args);
		System.out.println("@SpringBootApplication1 main ends.....");
	}

}

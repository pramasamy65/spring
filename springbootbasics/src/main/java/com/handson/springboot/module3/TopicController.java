package com.handson.springboot.module3;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@RequestMapping("/topics")
	public List<String> getAllTopics() {

		return Arrays.asList(new String[] { "Java", "Spring", "Spring Boot", "Hibernate" });

	}
}

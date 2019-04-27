/**
 * 
 */
package com.mentorondemand.SkillsTechnologies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skillstech")
public class SkillsTechnologiesController {
	/*
	 * To Access from Zuul API Gateway
	 * http://localhost:9090/hackFsePortal/sampleMetricsService/skillstech/hello 
	 */
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Hello";
	}
}

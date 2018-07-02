package com.handson.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.handson.springmvc.model.Exercise;

@Controller
public class MinutesController {

	@RequestMapping("/addMinutes")
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("Minutes exercised for the day " + exercise.getMinutes());
		return "forward:addMoreMinutes";
	}

	@RequestMapping("/addMoreMinutes")
	public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("More Minutes exercised for the day " + exercise.getMinutes());
		return "addMinutes";
	}
}

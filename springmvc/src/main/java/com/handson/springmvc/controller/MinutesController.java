package com.handson.springmvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.handson.springmvc.model.Activity;
import com.handson.springmvc.model.Exercise;
import com.handson.springmvc.service.ExcerciseService;

@Controller
public class MinutesController {

	@Autowired
	private ExcerciseService excerciseService;

	@RequestMapping(value = "/addMinutes", method = RequestMethod.GET)
	public String addMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("Minutes exercised for the day " + exercise.getMinutes());
		System.out.println("Performed Activity for the day " + exercise.getActivity());
		return "forward:addMoreMinutes";
	}

	@RequestMapping(value = "/addMinutes", method = RequestMethod.POST)
	public String UpdateMinutes(@Valid @ModelAttribute("exercise") Exercise exercise, BindingResult bResults) {
		System.out.println("Minutes exercised for the day " + exercise.getMinutes());
		System.out.println("Performed Activity for the day " + exercise.getActivity());
		if (bResults.hasErrors()) {
			System.out.println("addMinutes has Errors");
			return "addMinutes";
		}
		return "forward:addMoreMinutes";
	}

	@RequestMapping("/addMoreMinutes")
	public String addMoreMinutes(@ModelAttribute("exercise") Exercise exercise) {
		System.out.println("More Minutes exercised for the day " + exercise.getMinutes());
		System.out.println("Performed More Activity for the day " + exercise.getActivity());
		return "addMinutes";
	}

	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		return excerciseService.findAllActivities();
	}
}

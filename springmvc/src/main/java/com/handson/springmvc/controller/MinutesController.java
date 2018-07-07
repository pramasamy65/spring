package com.handson.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.handson.springmvc.model.Activity;
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

	@RequestMapping(value = "/activities", method = RequestMethod.GET)
	public @ResponseBody List<Activity> findAllActivities() {
		List<Activity> listOfActivities = new ArrayList<Activity>();
		Activity activity1 = new Activity();
		activity1.setDescription("Biking");
		Activity activity2 = new Activity();
		activity2.setDescription("Run");
		listOfActivities.add(activity1);
		listOfActivities.add(activity2);
		return listOfActivities;
	}
}

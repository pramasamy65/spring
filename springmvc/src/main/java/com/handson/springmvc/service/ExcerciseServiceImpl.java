package com.handson.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.handson.springmvc.model.Activity;

@Service
public class ExcerciseServiceImpl implements ExcerciseService {

	@Override
	public List<Activity> findAllActivities() {
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

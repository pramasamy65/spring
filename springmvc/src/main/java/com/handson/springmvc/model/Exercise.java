package com.handson.springmvc.model;

import org.hibernate.validator.constraints.Range;

public class Exercise {

	@Range(min = 25, max = 60)
	String minutes;

	String activity;

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}
}

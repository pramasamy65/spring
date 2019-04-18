package com.hackathon.hackathonbackend.genericmetric;

import java.util.List;

public interface GenericMetricsCustomRepository {
	
	List<GenericMetricOutputVo> uniqueVolunteeringDetails();

	List<GenericMetricOutputVo> uniqueVolunteeringDetailsByDate(String date);

	List<GenericMetricOutputVo> uniqueVolunteeringDetailsByMonth(String month);

	List<GenericMetricOutputVo> uniqueVolunteeringDetailsByDay(String day);

	List<GenericMetricOutputVo> volunteeringEffort();

}

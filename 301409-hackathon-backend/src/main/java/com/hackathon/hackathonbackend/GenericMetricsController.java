package com.hackathon.hackathonbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.hackathonbackend.genericmetric.GenericMetricOutputVo;
import com.hackathon.hackathonbackend.genericmetric.GenericMetricsCustomRepository;

@RequestMapping("/genericMetric")
@RestController

public class GenericMetricsController {

	@Autowired
	GenericMetricsCustomRepository genericMetricsRepository;

	@GetMapping("/uniqueVolunteeringDetails")
	public List<GenericMetricOutputVo> uniqueVolunteeringDetails() {
		List<GenericMetricOutputVo> uniqueVolunteeringDetails = genericMetricsRepository.uniqueVolunteeringDetails();
		System.out.println(" uniqueVolunteeringDetails " + uniqueVolunteeringDetails.size());
		System.out.println(uniqueVolunteeringDetails);
		return uniqueVolunteeringDetails;
	}

	@PostMapping("/uniqueVolunteeringDetailsByDay")
	public List<GenericMetricOutputVo> uniqueVolunteeringDetailsByDay(@RequestParam("day") String day) {
		List<GenericMetricOutputVo> uniqueVolunteeringDetailsByDay = genericMetricsRepository
				.uniqueVolunteeringDetailsByDay(day);
		System.out.println(" uniqueVolunteeringDetailsByDay " + uniqueVolunteeringDetailsByDay.size());
		System.out.println(uniqueVolunteeringDetailsByDay);
		return uniqueVolunteeringDetailsByDay;
	}

	@PostMapping("/uniqueVolunteeringDetailsByDate")
	public List<GenericMetricOutputVo> uniqueVolunteeringDetailsByDate(@RequestParam("date") String date) {
		List<GenericMetricOutputVo> uniqueVolunteeringDetailsByDate = genericMetricsRepository
				.uniqueVolunteeringDetailsByDate(date);
		System.out.println(" uniqueVolunteeringDetailsByDate " + uniqueVolunteeringDetailsByDate.size());
		System.out.println(uniqueVolunteeringDetailsByDate);
		return uniqueVolunteeringDetailsByDate;
	}

	@PostMapping("/uniqueVolunteeringDetailsByMonth")
	public List<GenericMetricOutputVo> uniqueVolunteeringDetailsByMonth(@RequestParam("month") String month) {
		List<GenericMetricOutputVo> uniqueVolunteeringDetailsByMonth = genericMetricsRepository
				.uniqueVolunteeringDetailsByMonth(month);
		System.out.println(" uniqueVolunteeringDetailsByMonth " + uniqueVolunteeringDetailsByMonth.size());
		System.out.println(uniqueVolunteeringDetailsByMonth);
		return uniqueVolunteeringDetailsByMonth;
	}

	@GetMapping("/volunteeringEffort")
	public List<GenericMetricOutputVo> volunteeringEffort() {
		List<GenericMetricOutputVo> volunteeringEffort = genericMetricsRepository.volunteeringEffort();
		System.out.println(" volunteeringEffort " + volunteeringEffort.size());
		System.out.println(volunteeringEffort);
		return volunteeringEffort;
	}

	public void run(String... args) throws Exception {

		List<GenericMetricOutputVo> uniqueVolunteeringDetails = genericMetricsRepository.uniqueVolunteeringDetails();
		System.out.println(" uniqueVolunteeringDetails " + uniqueVolunteeringDetails.size());
		System.out.println(uniqueVolunteeringDetails);

		List<GenericMetricOutputVo> uniqueVolunteeringDetailsByDay = genericMetricsRepository
				.uniqueVolunteeringDetailsByDay("13");
		System.out.println(" uniqueVolunteeringDetailsByDay " + uniqueVolunteeringDetailsByDay.size());
		System.out.println(uniqueVolunteeringDetailsByDay);

		List<GenericMetricOutputVo> uniqueVolunteeringDetailsByDate = genericMetricsRepository
				.uniqueVolunteeringDetailsByDate("01-05-18");
		System.out.println(" uniqueVolunteeringDetailsByDate " + uniqueVolunteeringDetailsByDate.size());
		System.out.println(uniqueVolunteeringDetailsByDate);

		List<GenericMetricOutputVo> uniqueVolunteeringDetailsByMonth = genericMetricsRepository
				.uniqueVolunteeringDetailsByMonth("12");
		System.out.println(" uniqueVolunteeringDetailsByMonth " + uniqueVolunteeringDetailsByMonth.size());
		System.out.println(uniqueVolunteeringDetailsByMonth);

		List<GenericMetricOutputVo> volunteeringEffort = genericMetricsRepository.volunteeringEffort();
		System.out.println(" volunteeringEffort " + volunteeringEffort.size());
		System.out.println(volunteeringEffort);

	}
}

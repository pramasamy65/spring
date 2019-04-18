package com.hackathon.hackathonbackend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.hackathonbackend.engagementmetric.EngagementMetricsCustomRepositoryImpl;
import com.hackathon.hackathonbackend.genericmetric.GenericMetricOutputVo;

@RequestMapping("/engagementMetrics")
@RestController
public class EngagementMetricsController {

	@Autowired
	EngagementMetricsCustomRepositoryImpl engagementMetricsCustomRepository;

	@GetMapping("/volunteerFrequency")
	public List<GenericMetricOutputVo> volunteerFrequency() {
		List<GenericMetricOutputVo> volunteerFrequency = engagementMetricsCustomRepository.volunteerFrequency();
		System.out.println(" uniqueVolunteeringDetails " + volunteerFrequency.size());
		System.out.println(volunteerFrequency);
		return volunteerFrequency;
	}

	public void run(String... args) throws Exception {

		List<GenericMetricOutputVo> volunteerFrequency = engagementMetricsCustomRepository.volunteerFrequency();
		System.out.println(" uniqueVolunteeringDetails " + volunteerFrequency.size());
		System.out.println(volunteerFrequency);
	}

}

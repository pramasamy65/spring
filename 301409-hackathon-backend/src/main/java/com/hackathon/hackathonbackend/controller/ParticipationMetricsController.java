package com.hackathon.hackathonbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.hackathonbackend.genericmetric.GenericMetricOutputVo;
import com.hackathon.hackathonbackend.participationmetric.ParticipationMetricsCustomRepository;
import com.hackathon.hackathonbackend.participationmetric.ParticipationMetricsRepository;
import com.hackathon.hackathonbackend.vo.AssociateDetailsVO;

@RestController
@RequestMapping("/participationMetrics")
public class ParticipationMetricsController {

	@Autowired
	ParticipationMetricsCustomRepository participationMetricsCustomRepository;

	@Autowired
	ParticipationMetricsRepository participationMetricsRepository;

	@GetMapping("/headCount")
	public List<AssociateDetailsVO> headCount() {
		List<AssociateDetailsVO> headCountList = participationMetricsRepository.findAll();
		System.out.println(" headCountList " + headCountList.size());
		System.out.println(headCountList);
		return headCountList;
	}

	@GetMapping("/uniqueVolunteeringDetailsByLocation/{location}")
	public List<GenericMetricOutputVo> uniqueVolunteeringDetailsByLocation(@PathVariable(name="location") String location) {
		
		List<GenericMetricOutputVo> uniqueVolunteeringDetailsByLocation = participationMetricsCustomRepository
				.uniqueVolunteeringDetailsByLocation(location);
		System.out.println(" uniqueVolunteeringDetailsByLocation " + uniqueVolunteeringDetailsByLocation.size());
		System.out.println(uniqueVolunteeringDetailsByLocation);
		return uniqueVolunteeringDetailsByLocation;
	}

	@GetMapping("/uniqueVolunteeringDetailsByBU/{businessUnit}")
	public List<GenericMetricOutputVo> uniqueVolunteeringDetailsByBU(@PathVariable(name="businessUnit") String businessUnit) {

		List<GenericMetricOutputVo> uniqueVolunteeringDetailsByBU = participationMetricsCustomRepository
				.uniqueVolunteeringDetailsByBU(businessUnit);
		System.out.println(" uniqueVolunteeringDetailsByBU " + uniqueVolunteeringDetailsByBU.size());
		System.out.println(uniqueVolunteeringDetailsByBU);
		return uniqueVolunteeringDetailsByBU;
	}

	public void run(String... args) throws Exception {

		List<AssociateDetailsVO> headCount = participationMetricsRepository.findAll();
		System.out.println(" findAllAssociateId " + headCount.size());
		System.out.println(headCount);

		List<GenericMetricOutputVo> uniqueVolunteeringDetailsByLocation = participationMetricsCustomRepository
				.uniqueVolunteeringDetailsByLocation("Pune");
		System.out.println(" uniqueVolunteeringDetailsByLocation " + uniqueVolunteeringDetailsByLocation.size());
		System.out.println(uniqueVolunteeringDetailsByLocation);

		List<GenericMetricOutputVo> uniqueVolunteeringDetailsByBU = participationMetricsCustomRepository
				.uniqueVolunteeringDetailsByBU("Cognizant Digital Operations");
		System.out.println(" uniqueVolunteeringDetailsByBU " + uniqueVolunteeringDetailsByBU.size());
		System.out.println(uniqueVolunteeringDetailsByBU);

	}
}

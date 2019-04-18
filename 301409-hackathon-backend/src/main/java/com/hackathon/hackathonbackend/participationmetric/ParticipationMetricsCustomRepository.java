package com.hackathon.hackathonbackend.participationmetric;

import java.util.List;

import com.hackathon.hackathonbackend.genericmetric.GenericMetricOutputVo;

public interface ParticipationMetricsCustomRepository {

	List<GenericMetricOutputVo> uniqueVolunteeringDetailsByLocation(String baseLocation);
	
	List<GenericMetricOutputVo> uniqueVolunteeringDetailsByBU(String businessUnit);

}

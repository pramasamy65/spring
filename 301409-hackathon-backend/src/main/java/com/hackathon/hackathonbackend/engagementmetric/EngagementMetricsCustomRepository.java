package com.hackathon.hackathonbackend.engagementmetric;

import java.util.List;

import com.hackathon.hackathonbackend.genericmetric.GenericMetricOutputVo;

public interface EngagementMetricsCustomRepository {

	List<GenericMetricOutputVo> volunteerFrequency();

}

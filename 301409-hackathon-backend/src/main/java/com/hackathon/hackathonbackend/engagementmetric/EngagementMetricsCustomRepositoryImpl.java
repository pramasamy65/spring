package com.hackathon.hackathonbackend.engagementmetric;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathonbackend.genericmetric.GenericMetricOutputVo;
import com.hackathon.hackathonbackend.vo.EventInformationVO;

@Repository
public class EngagementMetricsCustomRepositoryImpl implements EngagementMetricsCustomRepository {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public EngagementMetricsCustomRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<GenericMetricOutputVo> volunteerFrequency() {

		TypedAggregation<EventInformationVO> aggregation = Aggregation.newAggregation(EventInformationVO.class,
				Aggregation.group("employeeName", "employeeId").sum("volunteerHours").as("totalVolunteerHours")
						.sum("travelHours").as("totalTravelHours").sum("livesImpacted").as("livesImpacted").count()
						.as("volunteerFrequency"));

		AggregationResults<GenericMetricOutputVo> results = mongoTemplate.aggregate(aggregation,
				GenericMetricOutputVo.class);

		return results.getMappedResults();
	}

}

package com.hackathon.hackathonbackend.participationmetric;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathonbackend.genericmetric.GenericMetricOutputVo;
import com.hackathon.hackathonbackend.vo.EventInformationVO;

@Repository
public class ParticipationMetricsCustomRepositoryImpl implements ParticipationMetricsCustomRepository {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public ParticipationMetricsCustomRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}


	@Override
	public List<GenericMetricOutputVo> uniqueVolunteeringDetailsByLocation(String baseLocation) {
		TypedAggregation<EventInformationVO> aggregation = Aggregation.newAggregation(EventInformationVO.class,
				Aggregation.match(Criteria.where("baseLocation").is(baseLocation)),
				Aggregation.group("employeeName", "employeeId", "baseLocation").sum("volunteerHours")
						.as("totalVolunteerHours").sum("travelHours").as("totalTravelHours").sum("livesImpacted")
						.as("livesImpacted").count().as("volunteerFrequency"));

		AggregationResults<GenericMetricOutputVo> results = mongoTemplate.aggregate(aggregation,
				GenericMetricOutputVo.class);

		return results.getMappedResults();
	}

	@Override
	public List<GenericMetricOutputVo> uniqueVolunteeringDetailsByBU(String businessUnit) {
		TypedAggregation<EventInformationVO> aggregation = Aggregation.newAggregation(EventInformationVO.class,
				Aggregation.match(Criteria.where("businessUnit").is(businessUnit)),
				Aggregation.group("employeeName", "employeeId", "businessUnit").sum("volunteerHours")
						.as("totalVolunteerHours").sum("travelHours").as("totalTravelHours").sum("livesImpacted")
						.as("livesImpacted").count().as("volunteerFrequency"));

		AggregationResults<GenericMetricOutputVo> results = mongoTemplate.aggregate(aggregation,
				GenericMetricOutputVo.class);

		return results.getMappedResults();
	}

}

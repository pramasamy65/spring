package com.hackathon.hackathonbackend.genericmetric;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathonbackend.vo.EventInformationVO;

@Repository
public class GenericMetricsCustomRepositoryImpl implements GenericMetricsCustomRepository {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public GenericMetricsCustomRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	

	public List<GenericMetricOutputVo> uniqueVolunteeringDetails() {

		TypedAggregation<EventInformationVO> aggregation = Aggregation.newAggregation(EventInformationVO.class,
				Aggregation.group("employeeName", "employeeId").sum("volunteerHours").as("totalVolunteerHours")
						.sum("travelHours").as("totalTravelHours").sum("livesImpacted").as("livesImpacted"));

		AggregationResults<GenericMetricOutputVo> results = mongoTemplate.aggregate(aggregation,
				GenericMetricOutputVo.class);

		return results.getMappedResults();
	}

	public List<GenericMetricOutputVo> uniqueVolunteeringDetailsByDate(String date) {

		TypedAggregation<EventInformationVO> aggregation = Aggregation.newAggregation(EventInformationVO.class,
				Aggregation.match(Criteria.where("eventDate").is(date)));
		AggregationResults<GenericMetricOutputVo> results = mongoTemplate.aggregate(aggregation,
				GenericMetricOutputVo.class);

		return results.getMappedResults();
	}

	public List<GenericMetricOutputVo> uniqueVolunteeringDetailsByMonth(String month) {

		TypedAggregation<EventInformationVO> aggregation = Aggregation.newAggregation(EventInformationVO.class,
				Aggregation.match(Criteria.where("eventDate").regex("-" + month + "-")),
				Aggregation.group("employeeName", "employeeId", "eventDate").sum("volunteerHours")
						.as("totalVolunteerHours").sum("travelHours").as("totalTravelHours").sum("livesImpacted")
						.as("livesImpacted").addToSet("eventDate").as("eventDate"));
		AggregationResults<GenericMetricOutputVo> results = mongoTemplate.aggregate(aggregation,
				GenericMetricOutputVo.class);

		return results.getMappedResults();
	}

	public List<GenericMetricOutputVo> uniqueVolunteeringDetailsByDay(String day) {

		TypedAggregation<EventInformationVO> aggregation = Aggregation.newAggregation(EventInformationVO.class,
				Aggregation.match(Criteria.where("eventDate").regex(day + "-")),
				Aggregation.group("employeeName", "employeeId").sum("volunteerHours").as("totalVolunteerHours")
						.sum("travelHours").as("totalTravelHours").sum("livesImpacted").as("livesImpacted")
						.addToSet("eventDate").as("eventDate"));
		AggregationResults<GenericMetricOutputVo> results = mongoTemplate.aggregate(aggregation,
				GenericMetricOutputVo.class);

		return results.getMappedResults();
	}

	public List<GenericMetricOutputVo> volunteeringEffort() {

		TypedAggregation<EventInformationVO> aggregation = Aggregation.newAggregation(EventInformationVO.class,
				Aggregation.group().sum("volunteerHours").as("totalVolunteerHours").sum("travelHours")
						.as("totalTravelHours"));

		AggregationResults<GenericMetricOutputVo> results = mongoTemplate.aggregate(aggregation,
				GenericMetricOutputVo.class);

		return results.getMappedResults();
	}

}

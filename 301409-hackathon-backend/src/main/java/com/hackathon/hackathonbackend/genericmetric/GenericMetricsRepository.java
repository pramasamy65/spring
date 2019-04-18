package com.hackathon.hackathonbackend.genericmetric;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathonbackend.vo.EventInformationVO;

@Repository
public interface GenericMetricsRepository
		extends MongoRepository<EventInformationVO, String> {
	
	


}

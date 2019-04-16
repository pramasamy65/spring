package com.hackathon.hackathonbackend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathonbackend.vo.EventInformationVO;

@Repository
public interface EventInformationRepository extends MongoRepository<EventInformationVO, Long> {

}

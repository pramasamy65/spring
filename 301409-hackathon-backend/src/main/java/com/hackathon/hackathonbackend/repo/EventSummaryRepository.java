package com.hackathon.hackathonbackend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathonbackend.vo.EventSummaryVO;

@Repository
public interface EventSummaryRepository extends MongoRepository<EventSummaryVO, Long> {

}

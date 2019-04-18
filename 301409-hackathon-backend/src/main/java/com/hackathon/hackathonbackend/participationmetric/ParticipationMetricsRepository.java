package com.hackathon.hackathonbackend.participationmetric;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathonbackend.vo.AssociateDetailsVO;

@Repository
public interface ParticipationMetricsRepository extends MongoRepository<AssociateDetailsVO, Integer> {

}

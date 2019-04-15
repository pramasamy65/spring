package com.hackathon.hackathonbackend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathonbackend.vo.AssociateDetailsVo;

@Repository
public interface AssociateDetailsRepository extends MongoRepository<AssociateDetailsVo, Long> {

}

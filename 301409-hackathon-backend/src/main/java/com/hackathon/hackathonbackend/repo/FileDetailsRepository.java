package com.hackathon.hackathonbackend.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.hackathonbackend.vo.FileModificationDetailsVO;

@Repository
public interface FileDetailsRepository extends MongoRepository<FileModificationDetailsVO, Long> {

}

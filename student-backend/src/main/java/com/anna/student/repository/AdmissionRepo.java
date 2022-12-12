package com.anna.student.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.anna.student.model.AdmissionNum;

public interface AdmissionRepo extends MongoRepository <AdmissionNum,String>{
    
}

package com.anna.student.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.anna.student.model.Students;

@Repository
public interface StudentRepository extends MongoRepository<Students,String>{
    
}

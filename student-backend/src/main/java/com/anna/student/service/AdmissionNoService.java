package com.anna.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Service;

import com.anna.student.model.AdmissionNum;

import lombok.ToString;

import java.util.Objects;

// import  org.springframework.data.mongodb.core.FindAndModifyOptions;
import  org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@ToString
@Service
public class AdmissionNoService {
    @Autowired
    private MongoTemplate mongoTemplate;

  
    // public AdmissionNoService(MongoOperations mongoOperations) {
    //     this.mongoOperations = mongoOperations;
    // }

    public long generateSequence(String seqName) {

        Query query =new Query();
        query.addCriteria(Criteria.where("_id").is(seqName));
        AdmissionNum counter = mongoTemplate.findAndModify(query, new Update().inc("seq", 1),
        new FindAndModifyOptions().returnNew(true).upsert(true), AdmissionNum.class);
        return ( !Objects.isNull(counter) ? counter.getSeq() : 1);

    }
}

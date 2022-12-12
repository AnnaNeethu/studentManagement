package com.anna.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import com.anna.student.model.AdmissionNum;

public class AdmissionNoController {
    @Autowired
    private MongoOperations mongoOperations;

    public long getSeqNo(String seqName){
        Query query = new Query(Criteria.where("adNo").is(seqName));
        Update update = new Update().inc("seq",1);
        AdmissionNum counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
        AdmissionNum.class);
        
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}

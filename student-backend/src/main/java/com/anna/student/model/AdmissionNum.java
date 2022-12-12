package com.anna.student.model;

// import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection="Sequences")
public class AdmissionNum {
    
    private String id;
    private long seq;

    public AdmissionNum(){

    }

}

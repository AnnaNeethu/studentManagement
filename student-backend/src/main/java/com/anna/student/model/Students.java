package com.anna.student.model;

import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "Students")
public class Students {

    @Transient
    public static final String SEQUENCE_NAME = "R";

    @Id
    private String id;
    private String adNo;
    private String name;
    private String dob;
    private String cls;
    private String div;
    private String gender;

    public Students(){

    }

    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public String getDob() {
    //     return dob;
    // }
    // public void setDob(String dob) {
    //     this.dob = dob;
    // }
    // public String getCls() {
    //     return cls;
    // }
    // public void setCls(String cls) {
    //     this.cls = cls;
    // }
    // public String getDiv() {
    //     return div;
    // }
    // public void setDiv(String div) {
    //     this.div = div;
    // }
    // public String getGender() {
    //     return gender;
    // }
    // public void setGender(String gender) {
    //     this.gender = gender;
    // }
    
}

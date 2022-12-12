package com.anna.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anna.student.model.Students;
import com.anna.student.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;
    @PostMapping("/addStudent")
    public String saveStudent(@RequestBody Students students){
        service.saveStudent(students);
        return "Added student successfully" ;

    }
    @GetMapping("/view")
    public List<Students> getStudent(){
        return service.getStudent();
    }
}

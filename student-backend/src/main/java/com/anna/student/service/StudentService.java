package com.anna.student.service;

import java.util.List;

import com.anna.student.model.Students;

public interface StudentService {
    public Students saveStudent(Students students);
    public List<Students> getStudent();
}

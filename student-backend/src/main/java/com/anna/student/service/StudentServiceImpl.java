package com.anna.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anna.student.model.Students;
import com.anna.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;
    @Autowired
    private AdmissionNoService admissionNoService;
    @Override
    public Students saveStudent(Students students){
        long id = admissionNoService.generateSequence(Students.SEQUENCE_NAME);
        // String str =String.valueOf(id);
        // str  = String.format("%0" + str.length() + "d", Long.parseLong(str) + 1);
        String formattedStr = String.format("%03d", id);
			StringBuilder adId = new StringBuilder().append(Students.SEQUENCE_NAME)
					.append(formattedStr);
        // long id = admissionNoService.generateSequence(Students.SEQUENCE_NAME);
        students.setId(adId.toString());
        students.setAdNo(adId.toString());
        return repository.save(students);
    }
    @Override
    public List<Students> getStudent(){
        return repository.findAll();
    }
}

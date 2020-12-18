package com.example.education.impl;

import com.example.education.entity.Student;
import com.example.education.repo.StudentRepo;
import com.example.education.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;


    @Override
    public List<Student> findAll() {
        List<Student> student = studentRepo.findAll();
        if(student != null){
            return student;
        } else {
            return null;
        }
    }

    @Override
    public Student CreateStudent(Student student) {
        return studentRepo.save(student);
    }


}

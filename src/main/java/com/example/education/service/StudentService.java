package com.example.education.service;

import com.example.education.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Student CreateStudent(Student student);
}

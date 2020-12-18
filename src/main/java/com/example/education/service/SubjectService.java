package com.example.education.service;

import com.example.education.entity.Subject;
import com.example.education.entity.Teacher;
import javassist.NotFoundException;

import java.util.List;

public interface SubjectService {
    List<Subject> findAll();
    Subject CreateSubject(Subject subject,String tId) throws NotFoundException;
}

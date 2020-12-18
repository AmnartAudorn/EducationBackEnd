package com.example.education.service;

import com.example.education.entity.Enrolment;
import com.example.education.entity.Subject;
import javassist.NotFoundException;

import java.util.List;

public interface EnrolmentService {
    List<Enrolment> findAll();
    Enrolment CreateEnrolment(int stuId,String subjId) throws NotFoundException;
    List<Enrolment> findAllById(String subjId);
    List<Enrolment> enrolmentStudent();
    List<Enrolment> subjectGroupByIdStu();
}

package com.example.education.impl;

import com.example.education.entity.Enrolment;
import com.example.education.entity.Student;
import com.example.education.entity.Subject;
import com.example.education.repo.EnrolmentRepo;
import com.example.education.repo.StudentRepo;
import com.example.education.repo.SubjectRepo;
import com.example.education.service.EnrolmentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EnrolmentImpl implements EnrolmentService {
    @Autowired
    EnrolmentRepo enrolmentRepo;

    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    StudentRepo studentRepo;

    List<Enrolment> enrolmentsStudent = new ArrayList<>();



    @Override
    public List<Enrolment> findAll() {
        List<Enrolment> enrolments = enrolmentRepo.findAll();
        return enrolments;
    }

    @Override
    public List<Enrolment> enrolmentStudent() {
        return enrolmentsStudent;
    }

    @Override
    public List<Enrolment> subjectGroupByIdStu() {
        return enrolmentRepo.findAll();
    }

    @Override
    public Enrolment CreateEnrolment(int stuId,String subjId) throws NotFoundException {
        Subject subj = subjectRepo.findBysubjId(subjId);
        Student stu = studentRepo.findBystuId(stuId);

        Enrolment e = new Enrolment();
        e.setSubject(subj);
        e.setStudent(stu);
        return enrolmentRepo.save(e);
    }

    @Override
    public List<Enrolment> findAllById(String subjId) {
        List<Enrolment> enrolments = enrolmentRepo.findAll();
        enrolmentsStudent = new ArrayList<>();
        int i = 0;
        for (Enrolment enrol : enrolments){
            if (enrol.getSubject().getSubjId().equals(subjId)){
                enrolmentsStudent.add(enrolments.get(i));
            }
            i++;}
        return enrolmentsStudent;
    }


}

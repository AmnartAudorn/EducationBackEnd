package com.example.education.impl;

import com.example.education.entity.Student;
import com.example.education.entity.Subject;
import com.example.education.entity.Teacher;
import com.example.education.repo.StudentRepo;
import com.example.education.repo.SubjectRepo;
import com.example.education.repo.TeacherRepo;
import com.example.education.service.SubjectService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class SubjectImpl implements SubjectService {
    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public List<Subject> findAll() {
        List<Subject> subjects = subjectRepo.findAll();
        if(subjects != null){
            return subjects;
        }else {
            return null;
        }
    }



    @Override
    public Subject CreateSubject(Subject subject, String tId) throws NotFoundException {
        return teacherRepo.findById(tId)
                .map(teacher -> {
                    subject.setTeacher(teacher);
                    return subjectRepo.save(subject);
                }).orElseThrow(() -> new NotFoundException("not found!"));
    }



}

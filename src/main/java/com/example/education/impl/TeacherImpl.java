package com.example.education.impl;

import com.example.education.entity.Student;
import com.example.education.entity.Teacher;
import com.example.education.repo.StudentRepo;
import com.example.education.repo.TeacherRepo;
import com.example.education.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherImpl implements TeacherService {
    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = teacherRepo.findAll();
        if(teachers != null){
            return teachers;
        } else {
            return null;
        }
    }


    @Override
    public Teacher CreateTeacher(Teacher teacher) {

        return teacherRepo.save(teacher);
    }
}

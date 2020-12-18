package com.example.education.service;

import com.example.education.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    Teacher CreateTeacher(Teacher teacher);
}

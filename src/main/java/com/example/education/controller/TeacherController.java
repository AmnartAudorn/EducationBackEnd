package com.example.education.controller;

import com.example.education.entity.Student;
import com.example.education.entity.Teacher;
import com.example.education.service.StudentService;
import com.example.education.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/searchTeacher")
    public List<Teacher> searchTeacher(){
        return teacherService.findAll();
    }


    @PostMapping("/createTeacher")
    public Teacher createStudent(@RequestBody Teacher teacher){

        return teacherService.CreateTeacher(teacher);
    }

}

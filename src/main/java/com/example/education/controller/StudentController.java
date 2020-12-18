package com.example.education.controller;


import com.example.education.entity.Student;
import com.example.education.repo.StudentRepo;
import com.example.education.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/searchStudent")
    public List<Student> searchStudent(){
        return studentService.findAll();
    }



    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student){
        return studentService.CreateStudent(student);
    }


}

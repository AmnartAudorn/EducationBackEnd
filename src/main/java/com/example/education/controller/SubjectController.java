package com.example.education.controller;


import com.example.education.entity.Subject;
import com.example.education.service.SubjectService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/searchSubject")
    public List<Subject> searchSubject(){
        return subjectService.findAll();
    }

    @PostMapping("/createSubject/{tId}")
    public Subject createSubject(@Validated @RequestBody Subject subject, @PathVariable String tId) throws NotFoundException {
        return subjectService.CreateSubject(subject,tId);
    }

}

package com.example.education.controller;

import com.example.education.dto.GetEnrolmentStuDto;
import com.example.education.dto.RequestCreateEnrollmentDto;
import com.example.education.entity.Enrolment;
import com.example.education.service.EnrolmentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EnrolmentController {
    @Autowired
    EnrolmentService enrolmentService;

    @GetMapping("/searchEnrolment")
    public List<Enrolment> searchEnrolment(){
        return enrolmentService.findAll();
    }

    @PostMapping("/createEnrolment")
    public Enrolment createEnrolment(@RequestBody RequestCreateEnrollmentDto request) throws NotFoundException {
        return enrolmentService.CreateEnrolment(request.getStuId(),request.getSubjId());
    }

    @GetMapping("/searchEnrolmentSubject")
    public List<Enrolment> enrolmentStudent(){

        return enrolmentService.enrolmentStudent();
    }

    @PostMapping("/searchEnrolmentSubject")
    public List<Enrolment> findAllBySubjId(@RequestBody GetEnrolmentStuDto getEnrolmentStuDto) {
        System.out.println(getEnrolmentStuDto.getSubjId());
        return enrolmentService.findAllById(getEnrolmentStuDto.getSubjId());
    }

    @GetMapping("/searchGroupByEnrolmentHello")
    public List<Enrolment> searchGroupByEnrolment(){
        return enrolmentService.subjectGroupByIdStu();
    }

}

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
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


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
       try {


        Subject subj = subjectRepo.findBysubjId(subjId);
        Student stu = studentRepo.findByStuId(stuId);
        List<Subject> subjectList = subjectRepo.findAll();
        Enrolment e = new Enrolment();

        for(Subject sub :  subjectList){
            if(sub.getSubjId().equals(subjId)){
                //System.out.println(stuId);
                System.out.println(sub.getStartTime());
                //System.out.println(subj);
                //System.out.println(stuId);

                //เช็คช่วงเวลาหากเวลาที่เลือกลง อยู่ในช่วงเวลาที่มีอยู่แล้วไม่สามารถลงได้
                List<String> list = enrolmentRepo.getTimeBySubject(sub.getStartTime());

                if(list == null){
                    e.setSubject(subj);
                    e.setStudent(stu);
                }else{
                    return null;
                }
            }
        }
        return enrolmentRepo.save(e);
       }catch (Exception e){
           System.out.println("Not Success!!!");
           return null;
       }
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

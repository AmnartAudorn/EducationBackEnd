package com.example.education.repo;

import com.example.education.entity.Enrolment;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EnrolmentRepo extends JpaRepository<Enrolment,Long> {

    @Query("SELECT count(enrolment.stu_id) FROM enrolment  JOIN Student ON enrolment.stu_id = Student.stu_id \n" +
            " JOIN subject ON enrolment.subj_id = subject.subj_id Where '?1' between subject.start_time and subject.end_time")
    List<String> getTimeBySubject(String time);


}

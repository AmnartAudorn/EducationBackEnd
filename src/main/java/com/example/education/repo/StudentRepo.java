package com.example.education.repo;

import com.example.education.entity.Student;
import com.example.education.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    Student findBystuId(Integer stuId);
}

package com.example.education.repo;

import com.example.education.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TeacherRepo extends JpaRepository<Teacher, String> {
    Teacher findBytId(String tid);
}

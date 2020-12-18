package com.example.education.repo;

import com.example.education.entity.Student;
import com.example.education.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,String> {

    Optional<Teacher> findById(String tId);
}

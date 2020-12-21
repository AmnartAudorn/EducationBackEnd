package com.example.education.repo;

import com.example.education.entity.Subject;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface SubjectRepo extends JpaRepository<Subject,String> {
    Subject findBysubjId(String subjId);

}

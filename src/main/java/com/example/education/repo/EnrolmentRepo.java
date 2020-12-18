package com.example.education.repo;

import com.example.education.entity.Enrolment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnrolmentRepo extends JpaRepository<Enrolment,Long> {
}

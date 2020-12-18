package com.example.education.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@CrossOrigin(origins = "http://localhost:3000")
@Data
@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Enrolment {
    @GeneratedValue
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "stuId")
    Student student;

    @ManyToOne
    @JoinColumn(name = "subjId")
    Subject subject;
}

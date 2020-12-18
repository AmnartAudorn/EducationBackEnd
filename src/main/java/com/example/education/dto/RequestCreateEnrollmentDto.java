package com.example.education.dto;

import com.example.education.entity.Enrolment;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RequestCreateEnrollmentDto {
    private int stuId;
    private String subjId;
}

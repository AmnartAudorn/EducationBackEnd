package com.example.education.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Subject {

    @Id
    String subjId;
    String subjName;
    String subjDetails;
    int subjCredit;
    String startTime;
    String endTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tId", referencedColumnName = "tId")
    private Teacher teacher;

}

package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idQuiz;
    @OneToMany
    private List<Question> question;
}

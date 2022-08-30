package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ScoreQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idScore;
    @ManyToOne
    private Quiz quiz;
    @ManyToOne
    private AppUser appUser;
    private int score;
}

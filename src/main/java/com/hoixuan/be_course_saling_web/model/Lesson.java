package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLesson;
    @NotBlank
    private String nameLesson;
    @NotBlank
    private String contentLesson;
    @NotBlank
    private String linkVideo;
    private String timeLesson;
}

package com.hoixuan.be_course_saling_web.model.dto;

import lombok.Data;

@Data
public class Criteria {
    String nameCourse;
    Integer from;
    Integer to;
    Integer experience;
    String nameInstructor;
    Integer rating;
}

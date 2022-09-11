package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
@Entity
@Data
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idInstructor;
    private String nameInstructor;
    @Email
    private String emailInstructor;
    private Date dateOfBirthInstructor;
    private String phoneInstructor;
    private String AvatarInstructor;
    private int experience;
}

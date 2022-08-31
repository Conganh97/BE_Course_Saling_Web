package com.hoixuan.be_course_saling_web.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "nameCourse"
        })
})
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCourse;
    @NotBlank
    @Column(unique = true)
    private String nameCourse;
    @NotBlank
    private double priceCourse;
    @NotBlank
    @Column(length = 10000)
    private String descriptionCourse;
    private int timeCourse;
    @ManyToOne
    private Instructor instructor;
    private int quantity = 0;
    private boolean statusCourse = true;
    private int numRating;
    @OneToOne
    private Quiz quiz;
    @OneToOne
    private Certificate certificate;
}

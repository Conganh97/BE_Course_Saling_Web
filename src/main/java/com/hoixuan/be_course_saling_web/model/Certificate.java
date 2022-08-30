package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCertificate;
    @NotBlank
    private String nameCertificate;
    @NotBlank
    private String imageCertificate;
}

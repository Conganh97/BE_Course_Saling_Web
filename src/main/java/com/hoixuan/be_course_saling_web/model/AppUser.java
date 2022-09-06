package com.hoixuan.be_course_saling_web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@Entity

public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String fullName;

    @Size(max = 20,min = 6)
    @Column(unique = true)
    private String userName;
    @Size(max = 16,min = 6)

    @JsonIgnore
    private String password;
    @Email
    private String email;

    private String address;

    private String phone;

    private String avatarSrc;
    @Column(length = 1000000)
    private String description;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<Role> roles;
    private boolean status = true;
}

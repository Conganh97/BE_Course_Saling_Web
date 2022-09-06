package com.hoixuan.be_course_saling_web.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "userName"
        })
})
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String fullName;

    @Size(max = 20,min = 6)
    @Column(unique = true)
    private String userName;
//    @Size(max = 16,min = 6)

    @Column(length = 10000)
    private String password;
    private String confirmPassword;
    @Email
    private String email;

    private String address;
    private Date dateOfBirth;

    private String phone;

    private String avatarSrc;
    @Column(length = 1000000)
    private String description;
    private boolean status = true;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    private Set<Role> roles;

}

package com.hoixuan.be_course_saling_web.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String nameRole;
    @Override
    public String getAuthority() {
        return nameRole;
    }


}

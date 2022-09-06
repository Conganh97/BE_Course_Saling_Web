package com.hoixuan.be_course_saling_web.dto;
import com.hoixuan.be_course_saling_web.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccRegister {
    private String userName;
    private String password;
    private String confirmPassword;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

}

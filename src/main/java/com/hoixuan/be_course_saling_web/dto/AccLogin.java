package com.hoixuan.be_course_saling_web.dto;

import com.hoixuan.be_course_saling_web.model.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class AccLogin {

    private long id;
    private String userName;
    private String password;
    private String confirmPassword;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

package com.hoixuan.be_course_saling_web.repository.UserRepository;

import com.hoixuan.be_course_saling_web.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

}

package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}

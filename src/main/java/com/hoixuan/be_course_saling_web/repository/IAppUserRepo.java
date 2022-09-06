package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUserName(String userName);

     Boolean existsByUserName(String userName) ;

    Boolean existsByEmail(String email);


    }


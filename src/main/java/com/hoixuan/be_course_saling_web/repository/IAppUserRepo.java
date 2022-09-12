package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    @Query(nativeQuery = true, value = "select * from app_user where user_name like concat ('%',:name,'%');")
    AppUser findByUserNameS(@Param("name") String name);

    AppUser findByUserName(String name);

    AppUser findByEmail(String email);

    AppUser findById(long idUser);
}

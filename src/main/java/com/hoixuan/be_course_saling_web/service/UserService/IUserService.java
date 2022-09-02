package com.hoixuan.be_course_saling_web.service.UserService;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService extends IGeneralService<AppUser> {
    Iterable<AppUser> findAll();

    Optional<AppUser> findById(Long id);

    AppUser save(AppUser appUser);

    void remove(Long idUser);
}

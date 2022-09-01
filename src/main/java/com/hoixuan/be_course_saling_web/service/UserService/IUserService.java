package com.hoixuan.be_course_saling_web.service.UserService;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService extends IGeneralService<AppUser> {
    Page<AppUser> getAll(Pageable pageable);
}

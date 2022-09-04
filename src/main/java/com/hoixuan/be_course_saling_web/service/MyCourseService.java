package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.MyCourse;
import com.hoixuan.be_course_saling_web.repository.IMyCourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MyCourseService {
    @Autowired
    IMyCourseRepo iMyCourseRepo;

    @Autowired
    AppUserService appUserService;


    public List<MyCourse> findAllMyCourseByIdUser (long idUser){
        return iMyCourseRepo.findAllMyCourseById(idUser);
    }

    public long findIdUser () {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return appUserService.findByUserName("conganh").getIdUser();
    }


}

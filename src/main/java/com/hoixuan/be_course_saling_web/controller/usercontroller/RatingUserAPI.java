package com.hoixuan.be_course_saling_web.controller.usercontroller;


import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.MyCourse;
import com.hoixuan.be_course_saling_web.model.Rating;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.CourseService;
import com.hoixuan.be_course_saling_web.service.MyCourseService;
import com.hoixuan.be_course_saling_web.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class RatingUserAPI {

    @Autowired
    RatingService ratingService;

    @Autowired
    AppUserService appUserService;

    @Autowired
    CourseService courseService;

    @Autowired
    MyCourseService myCourseService;

    @GetMapping("/getALlRating/{id}")
    public ResponseEntity<List<Rating>> getAllByCourse(@PathVariable long id){
        return new ResponseEntity<>(ratingService.getAllByCourseId(id), HttpStatus.OK);
    }

    @PostMapping("/createRating/{idCourse}")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating, @PathVariable long idCourse){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        MyCourse myCourse = myCourseService.findMyCourse(appUserService.findByUserName(userDetails.getUsername()).getIdUser());
        Course course = courseService.findByIdCourse(idCourse);
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        myCourse.setCourse(course);
        rating.setAppUser(appUser);
        rating.setCourse(course);
        rating.setNumStar(0);
        return new ResponseEntity<>(ratingService.save(rating),HttpStatus.OK);

    }
}
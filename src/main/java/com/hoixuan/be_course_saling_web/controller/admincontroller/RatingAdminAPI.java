package com.hoixuan.be_course_saling_web.controller.admincontroller;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.Rating;
import com.hoixuan.be_course_saling_web.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class RatingAdminAPI {
    @Autowired
    RatingService ratingService;
    @GetMapping("/rating/{id}")
    public ResponseEntity<List<Rating>>getAllByIdCourse(@PathVariable long id){
        return new ResponseEntity<>(ratingService.getAllByCourseId(id), HttpStatus.OK);
    }
    @GetMapping("/rating/approval/{id}")
    public Rating approvalById(@PathVariable long id){
        Rating rating = ratingService.findById(id);
        rating.setStatusRating(true);
        return ratingService.save(rating);
    }
    @GetMapping("/rating/delete/{id}")
    public Rating deleteById(@PathVariable long id){
        ratingService.delete(id);
        return new Rating();
    }
}

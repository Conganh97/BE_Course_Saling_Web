package com.hoixuan.be_course_saling_web.controller.CourseController;


import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.service.CourseService.CourseService;
import com.hoixuan.be_course_saling_web.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("")
    public ResponseEntity<Iterable<Course>> showAllUser() {
        Iterable<Course> courses = courseService.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{idCourse}")
    public ResponseEntity<Course> findCourseById(@PathVariable Long idCourse) {
        Optional<Course> courseOptional = courseService.findById(idCourse);
        if (!courseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(courseOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody Course course) {
        courseService.save(course);
    }

    @PutMapping
    public void edit(@RequestBody Course course) {
        courseService.save(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course>updateCmt(@PathVariable Long id,@RequestBody Course course) {
        Optional<Course> course1 = courseService.findById(id);
        if (!course1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        appUser1.(appUser.get().getIdUser());
        courseService.save(course);
        return new ResponseEntity<>(course,HttpStatus.CREATED);
    }


    @DeleteMapping("/{idCourse}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long idCourse) {
        Optional<Course> courseOptional = courseService.findById(idCourse);
        if (!courseOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        courseService.remove(idCourse);
        return new ResponseEntity<>(courseOptional.get(), HttpStatus.NO_CONTENT);
    }
}








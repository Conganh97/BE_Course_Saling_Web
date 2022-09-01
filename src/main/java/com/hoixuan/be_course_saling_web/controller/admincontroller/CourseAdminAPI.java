package com.hoixuan.be_course_saling_web.controller.admincontroller;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class CourseAdminAPI {
    @Autowired
    CourseService courseService;

    @GetMapping("/{page}")
    public ResponseEntity<Page<Course>> getAll(@PathVariable(required = true) int page) {
        Page<Course> coursePage = courseService.getAll(PageRequest.of(page, 5, Sort.by("nameCourse")));
        return  new ResponseEntity<>(coursePage, HttpStatus.OK);
    }
}

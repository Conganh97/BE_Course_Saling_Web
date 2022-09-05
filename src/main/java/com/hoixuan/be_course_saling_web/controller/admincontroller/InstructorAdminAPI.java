package com.hoixuan.be_course_saling_web.controller.admincontroller;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.Instructor;
import com.hoixuan.be_course_saling_web.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class InstructorAdminAPI {
    @Autowired
    InstructorService instructorService;
    @GetMapping("/instructor")
    public ResponseEntity<List<Instructor>> getAll() {
        return new ResponseEntity<>(instructorService.getAll(), HttpStatus.OK);
    }
}

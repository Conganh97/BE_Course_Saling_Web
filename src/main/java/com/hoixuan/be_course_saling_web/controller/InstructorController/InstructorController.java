package com.hoixuan.be_course_saling_web.controller.InstructorController;

import com.hoixuan.be_course_saling_web.model.Instructor;
import com.hoixuan.be_course_saling_web.service.InstructorService;
import com.hoixuan.be_course_saling_web.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired
    InstructorService instructorService;
    @GetMapping("")
    public ResponseEntity<Iterable<Instructor>> showAllUser() {
        Iterable<Instructor> instructors = instructorService.findAll();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

}

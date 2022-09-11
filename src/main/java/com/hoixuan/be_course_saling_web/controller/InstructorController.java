package com.hoixuan.be_course_saling_web.controller;

import com.hoixuan.be_course_saling_web.model.Instructor;
import com.hoixuan.be_course_saling_web.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/instructors")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @GetMapping("/instructors")
    public ResponseEntity<Iterable<Instructor>> showAllInstructor() {
        Iterable<Instructor> instructors = instructorService.findAll();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }


    @GetMapping("/instructor")
    public ResponseEntity<List<Instructor>> getAll() {
        return new ResponseEntity<>(instructorService.getAll(), HttpStatus.OK);
    }

//    @GetMapping("/instructor/{page}")
//    public ResponseEntity<Page<Instructor>> getAllPage(@PathVariable int page) {
//        Page<Instructor> instructors = instructorService.getAllPage(PageRequest.of(page, 9, Sort.by("nameInstructor")));
//        return new ResponseEntity<>(instructors, HttpStatus.OK);
//    }
//
//    @PostMapping("/instructor/save")
//    public ResponseEntity<Instructor> save(@RequestBody Instructor instructor) {
//        return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.OK);
//    }
//
//    @GetMapping("/instructor/delete/{id}")
//    public ResponseEntity<Instructor> getAllPage(@PathVariable long id) {
//        instructorService.delete(id);
//        return new ResponseEntity<>(new Instructor(), HttpStatus.OK);
    }


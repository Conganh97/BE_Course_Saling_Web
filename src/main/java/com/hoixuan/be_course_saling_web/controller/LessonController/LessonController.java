package com.hoixuan.be_course_saling_web.controller.LessonController;

import com.hoixuan.be_course_saling_web.model.Lesson;
import com.hoixuan.be_course_saling_web.service.LessonService;
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
@RequestMapping("/lessons")
public class LessonController {
    @Autowired
    LessonService lessonService;
    @GetMapping("")
    public ResponseEntity<Iterable<Lesson>> showAllUser() {
        Iterable<Lesson> lessons = lessonService.findAll();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }
}

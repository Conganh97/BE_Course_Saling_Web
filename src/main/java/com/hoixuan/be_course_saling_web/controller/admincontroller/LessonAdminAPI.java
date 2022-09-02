package com.hoixuan.be_course_saling_web.controller.admincontroller;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.Lesson;
import com.hoixuan.be_course_saling_web.service.CourseService;
import com.hoixuan.be_course_saling_web.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class LessonAdminAPI {
    @Autowired
    LessonService lessonService;
    @Autowired
    CourseService courseService;

    @GetMapping("/lesson/{id}")
    public ResponseEntity<List<Lesson>> getAllByIdCourse(@PathVariable long id) {
        return new ResponseEntity<>(lessonService.getAllByIdCourse(id), HttpStatus.OK);
    }

    @PostMapping("/lesson/{id}")
    public ResponseEntity<Lesson> save(@PathVariable long id,@RequestBody Lesson lesson) {
        Course course = courseService.findById(id);
        lesson.setCourse(course);
        return new ResponseEntity<>(lessonService.save(lesson), HttpStatus.OK);
    }
}

package com.hoixuan.be_course_saling_web.controller;

import com.hoixuan.be_course_saling_web.model.Lesson;
import com.hoixuan.be_course_saling_web.model.MyCourse;
import com.hoixuan.be_course_saling_web.model.dto.LessonLearned;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.MyCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("course")
public class MyCourseAPI {
    @Autowired
    AppUserService appUserService;

    @Autowired
    MyCourseService myCourseService;


    @GetMapping("/myCourse")
    public ResponseEntity<List<MyCourse>> getAllMyCourseByUser() {
        List<MyCourse> myCourses = myCourseService.findAllMyCourseByIdUser(myCourseService.findIdUser());
        return new ResponseEntity<>(myCourses, HttpStatus.ACCEPTED);
    }

    @GetMapping("/myCourseLearn/{idCourse}")
    public ResponseEntity<MyCourse> getMyCourseLearn(@PathVariable long idCourse){
        return new ResponseEntity<>(myCourseService.findMyCourseLearn(idCourse),HttpStatus.OK);
    }

    @PostMapping("/learned")
    public ResponseEntity<MyCourse> lessonLearned (@RequestBody LessonLearned lessonLearned){
        myCourseService.learned(lessonLearned.getIdMyCourse(),lessonLearned.getIdLesson());
        MyCourse myCourse = myCourseService.findMyCourseLearn(lessonLearned.getIdMyCourse());
        return new ResponseEntity<>(myCourse,HttpStatus.OK);
    }
}

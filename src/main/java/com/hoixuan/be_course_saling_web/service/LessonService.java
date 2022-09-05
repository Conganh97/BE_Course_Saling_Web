package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Lesson;
import com.hoixuan.be_course_saling_web.repository.ILessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    @Autowired
    ILessonRepo iLessonRepo;

//    public List<Lesson> getAllByIdCourse(long id) {
//        return iLessonRepo.getAllByCourseIdCourse(id);
//    }

    public Lesson save(Lesson lesson) {
        return iLessonRepo.save(lesson);
    }

    public Iterable<Lesson> findAll() {
        return iLessonRepo.findAll();
    }
}

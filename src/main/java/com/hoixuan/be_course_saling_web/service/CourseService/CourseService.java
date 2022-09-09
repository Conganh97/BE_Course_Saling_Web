package com.hoixuan.be_course_saling_web.service.CourseService;


import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.repository.CourseRepository.CourseRepository;
import com.hoixuan.be_course_saling_web.repository.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService implements ICourseService{
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }



    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void remove(Long idCourse) {
        courseRepository.deleteById(idCourse);
    }
}

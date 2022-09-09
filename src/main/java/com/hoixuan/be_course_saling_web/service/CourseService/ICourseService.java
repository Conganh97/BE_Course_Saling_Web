package com.hoixuan.be_course_saling_web.service.CourseService;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.service.IGeneralService;

import java.util.Optional;

public interface ICourseService extends IGeneralService<Course> {
    Iterable<Course> findAll();

    Optional<Course> findById(Long id);

    Course save(Course course);

    void remove(Long idCourse);
}

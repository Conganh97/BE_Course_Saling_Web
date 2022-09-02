package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICourseRepo extends PagingAndSortingRepository<Course, Long> {
    Course findByIdCourse(long id);
}

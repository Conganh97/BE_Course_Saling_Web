package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.MyCourse;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICourseRepo extends PagingAndSortingRepository<Course,Long> {

<<<<<<< HEAD
=======
    Course findByIdCourse(long id);


>>>>>>> 908e9a7f057ad2898ba0b39421b80fad420007ab
}

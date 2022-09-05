package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Rating;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRatingRepo extends CrudRepository<Rating,Long> {
    List<Rating> getAllByCourseIdCourse(long id);
}

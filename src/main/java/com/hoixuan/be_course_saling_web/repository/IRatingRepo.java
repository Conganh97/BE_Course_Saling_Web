package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface IRatingRepo extends PagingAndSortingRepository<Rating,Long> {
    List<Rating> getAllByCourseIdCourse(long id);



    Optional<Rating> findRatingByAppUserIdUserAndCourseIdCourse(long idUser, long idCourse);

}

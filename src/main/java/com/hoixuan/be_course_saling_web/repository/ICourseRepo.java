package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.MyCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICourseRepo extends PagingAndSortingRepository<Course,Long> {

    Course findByIdCourse(long id);

    @Query(nativeQuery = true,value = "SELECT * FROM course where status_course = 1 limit 3")
    List<Course> getTrendingCourse ();
@Query(nativeQuery = true,value = "SELECT * FROM course c join instructor i on c.instructor_id_instructor = i.id_instructor "
        + "where status_course = 1" + " and"
        + " (:nameCourse is null or name_course like :nameCourse)" + " and"
        + " (:from is null or price_course >= :from)" + " and"
        + " (:to is null or price_course <= :to)" + " and"
        + " (:experience is null or i.experience >= :experience)" + " and"
        + " (:nameInstructor is null or i.name_instructor like  :nameInstructor )" + "and"
        + " (:rating is null or num_rating >= :rating)")
    List<Course> getAllCourseByCriteria(@Param("nameCourse") String nameCourse,
                                         @Param("from") Integer down,
                                         @Param("to") Integer up,
                                         @Param("experience") Integer experience,
                                         @Param("nameInstructor") String nameInstructor,
                                         @Param("rating") Integer rating);
}

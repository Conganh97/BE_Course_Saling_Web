package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.MyCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMyCourseRepo extends PagingAndSortingRepository<MyCourse, Long> {
    @Query(nativeQuery = true,value = "select * from my_course where app_user_id_user = :idUser order by expire desc")
    List<MyCourse> findAllMyCourseById(@Param("idUser") long idUser);

    MyCourse findMyCourseByAppUserIdUserAndCourseIdCourse (long idUser, long idCourse);

    MyCourse findMyCourseByIdMyCourse (long idMyCourse);

    @Query(nativeQuery = true,value = "select my_course.id_my_course  from my_course join course  where my_course.course_id_course=course.id_course and name_course like %:nameSearch% ")
    List<Long> searchByName(@Param("nameSearch") String nameSearch);

}

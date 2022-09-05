package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface IInstructorRepo extends CrudRepository<Instructor,Long> {
}

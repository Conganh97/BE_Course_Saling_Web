package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Instructor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IInstructorRepo extends PagingAndSortingRepository<Instructor,Long> {
}

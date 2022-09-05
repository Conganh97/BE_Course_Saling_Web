package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ILessonRepo extends JpaRepository<Lesson, Long> {

}

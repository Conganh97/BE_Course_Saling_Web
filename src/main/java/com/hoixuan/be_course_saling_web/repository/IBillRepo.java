package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepo extends CrudRepository<Bill,Long> {
    List<Bill> getBillsByAppUserIdUser(long idUser);
    List<Bill> getBillsByCourseIdCourse(long idCourse);
}

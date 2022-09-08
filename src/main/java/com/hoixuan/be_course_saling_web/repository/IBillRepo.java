package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.Bill;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepo extends PagingAndSortingRepository <Bill,Long> {
}

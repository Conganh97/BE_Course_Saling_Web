package com.hoixuan.be_course_saling_web.repository;

import com.hoixuan.be_course_saling_web.model.RequestRecharge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRequestRechargeRepo extends CrudRepository<RequestRecharge,Long> {

    List<RequestRecharge> findByAppUserIdUser(long idUser);
}

package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Bill;
import com.hoixuan.be_course_saling_web.repository.IBillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    IBillRepo iBillRepo;

    public Bill save (Bill bill){
        return iBillRepo.save(bill);
    }
}

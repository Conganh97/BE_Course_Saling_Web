package com.hoixuan.be_course_saling_web.controller.admincontroller;

import com.hoixuan.be_course_saling_web.model.RequestRecharge;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.RequestRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class RequestRechargeAPI {
    @Autowired
    AppUserService appUserService;
    @Autowired
    RequestRechargeService requestRechargeService;

    @GetMapping("/requestRecharge")
    public ResponseEntity<List<RequestRecharge>> getAllRR (){
        return new ResponseEntity<>(requestRechargeService.getAll(), HttpStatus.OK);
    }
}

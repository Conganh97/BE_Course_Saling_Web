package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.RequestRecharge;
import com.hoixuan.be_course_saling_web.model.Wallet;
import com.hoixuan.be_course_saling_web.model.dto.Recharge;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.RequestRechargeService;
import com.hoixuan.be_course_saling_web.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/wallet")
public class WalletAPI {
    @Autowired
    WalletService walletService;
    @Autowired
    AppUserService appUserService;
    @Autowired
    RequestRechargeService requestRechargeService;
    @PostMapping("/recharge")
    public ResponseEntity<Wallet> recharge(@RequestBody Recharge recharge){
        Wallet wallet = walletService.findByIdUser(recharge.getIdUser());
        wallet.setMoney(wallet.getMoney() + recharge.getMoney());
        requestRechargeService.delete(recharge.getIdReq());
        return new ResponseEntity<>(walletService.save(wallet), HttpStatus.OK);
    }
}

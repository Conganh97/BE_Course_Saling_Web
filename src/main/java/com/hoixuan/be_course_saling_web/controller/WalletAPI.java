package com.hoixuan.be_course_saling_web.controller;

import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Wallet;
import com.hoixuan.be_course_saling_web.model.dto.Recharge;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("wallet")
public class WalletAPI {
    @Autowired
    WalletService walletService;
    @Autowired
    AppUserService appUserService;
    @PostMapping("/recharge")
    public ResponseEntity<Wallet> recharge(@RequestBody Recharge recharge){
                UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Wallet wallet = walletService.findByIdUser(appUserService.findByUserName(userDetails.getUsername()).getIdUser());
        wallet.setMoney(wallet.getMoney() + recharge.getMoney());
        return new ResponseEntity<>(walletService.save(wallet), HttpStatus.OK);
    }
}

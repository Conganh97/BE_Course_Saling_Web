package com.hoixuan.be_course_saling_web.controller;

import com.hoixuan.be_course_saling_web.dto.AccLogin;
import com.hoixuan.be_course_saling_web.dto.AccRegister;
import com.hoixuan.be_course_saling_web.dto.UserToken;
import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Role;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AppUserService appUserService;


    @Autowired
    PasswordEncoder passwordEncoder;






    @PostMapping("/login")
    public UserToken login(@RequestBody AccLogin accLogin) {
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(accLogin.getUserName(), accLogin.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtService.createToken(authentication);
            AppUser appUser1 = appUserService.findByUserName(accLogin.getUserName());
            return new UserToken(appUser1.getIdUser(), appUser1.getUserName(), token, appUser1.getRoles());
        } catch (Exception e) {
            return null;
        }

    }

//    @PostMapping("/register")
//    public ResponseEntity<AppUser> register( @RequestBody AccRegister accRegister) {
//        if (!accRegister.getPassword().equals(accRegister.getConfirmPassword())) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        if (appUserService.existsByUserName(accRegister.getUserName())) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        AppUser appUser = new AppUser(accRegister.getUserName(), passwordEncoder.encode(accRegister.getPassword()));
//        Set<Role> roles = new HashSet<>();
//        Role role = new Role();
//        role.setId(1);
//        roles.add(role);
//        appUser.setRoles(roles);
//        appUserService.save(appUser);
//
//        return new ResponseEntity<>(appUser, HttpStatus.OK);
//    }
@GetMapping("/admin/showUser")
public List<AppUser> getRegister() {
    return appUserService.getAll();
}



}






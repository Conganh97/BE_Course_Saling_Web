package com.hoixuan.be_course_saling_web.controller;

import com.hoixuan.be_course_saling_web.model.Instructor;
import com.hoixuan.be_course_saling_web.model.dto.AccLogin;
import com.hoixuan.be_course_saling_web.model.dto.UserToken;
import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Role;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.InstructorService;
import com.hoixuan.be_course_saling_web.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class LoginAPI {
    @Autowired
    JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AppUserService appUserService;


    @PostMapping("/login")
    public UserToken login(@RequestBody AccLogin accLogin){
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(accLogin.getUserName(), accLogin.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtService.createToken(authentication);
            AppUser appUser1 = appUserService.findByUserName(accLogin.getUserName());
            return new UserToken(appUser1.getIdUser(),appUser1.getUserName(),token,appUser1.getRoles());
        } catch (Exception e) {
            return null;
        }

    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser){
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(2);
        roles.add(role);
        appUser.setRoles(roles);
        return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.OK);
    }

    @RestController
    @CrossOrigin("*")
    @RequestMapping("/instructors")
    public static class InstructorController {
        @Autowired
        InstructorService instructorService;
        @GetMapping("")
        public ResponseEntity<Iterable<Instructor>> showAllUser() {
            Iterable<Instructor> instructors = instructorService.findAll();
            return new ResponseEntity<>(instructors, HttpStatus.OK);
        }

    }
}

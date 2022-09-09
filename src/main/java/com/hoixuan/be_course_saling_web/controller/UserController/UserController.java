package com.hoixuan.be_course_saling_web.controller.UserController;


import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.service.UserService.IUserService;
import com.hoixuan.be_course_saling_web.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
//    @Value("uploadPart")
//    String uploadPart;

    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<Iterable<AppUser>> showAllUser() {
        Iterable<AppUser> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<AppUser> findRoomById(@PathVariable Long idUser) {
        Optional<AppUser> userOptional = userService.findById(idUser);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public void create(@RequestBody AppUser appUser) {
        userService.save(appUser);
    }

    @PutMapping
    public void edit(@RequestBody AppUser appUser) {
        userService.save(appUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser>updateCmt(@PathVariable Long id,@RequestBody AppUser appUser) {
        Optional<AppUser> appUser1 = userService.findById(id);
        if (!appUser1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
//        appUser1.(appUser.get().getIdUser());
        userService.save(appUser);
        return new ResponseEntity<>(appUser,HttpStatus.CREATED);
    }


    @DeleteMapping("/{idUser}")
    public ResponseEntity<AppUser> deleteUser(@PathVariable Long idUser) {
        Optional<AppUser> userOptional = userService.findById(idUser);
        if (!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.remove(idUser);
        return new ResponseEntity<>(userOptional.get(), HttpStatus.NO_CONTENT);
    }
}

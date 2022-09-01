package com.hoixuan.be_course_saling_web.controller.UserController;


import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.service.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {
//    @Value("uploadPart")
//    String uploadPart;

    @Autowired
    IUserService userService;

    @GetMapping
    public Page<AppUser> getAll(@RequestParam(defaultValue = "0") int page) {
        return userService.getAll(PageRequest.of(page, 4));
    }

    @GetMapping("/{id}")
    public Optional<AppUser> findById(@PathVariable long id) {
        return userService.findById(id);
    }
}

package com.hoixuan.be_course_saling_web.controller.usercontroller;


import com.hoixuan.be_course_saling_web.model.AppUser;
import com.hoixuan.be_course_saling_web.model.Comment;
import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.dto.CommentCourse;
import com.hoixuan.be_course_saling_web.service.AppUserService;
import com.hoixuan.be_course_saling_web.service.CommentService;
import com.hoixuan.be_course_saling_web.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
public class CommentAPI {

    @Autowired
    CommentService commentService;

    @Autowired
    AppUserService appUserService;

    @Autowired
    CourseService courseService;


    @GetMapping("/getAll/{idCourse}")
    public ResponseEntity<List<Comment>> getAllComment (@PathVariable long idCourse){
        return new  ResponseEntity<>(commentService.findByComment(idCourse), HttpStatus.OK);
    }

    @PostMapping("/createCmt")
    public ResponseEntity<Comment> createCmt(@RequestBody CommentCourse commentCourse){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AppUser appUser = appUserService.findByUserName(userDetails.getUsername());
        if (commentCourse.getContentCmt().equals("")) return null;
        Comment comments = new Comment();
        comments.setCourse(courseService.findByIdCourse(commentCourse.getIdCourse()));
        comments.setContentCmt(commentCourse.getContentCmt());
        comments.setTimeCmt(new Date());
        comments.setAppUser(appUser);
        commentService.saveCMT(comments);

        return new ResponseEntity<>(comments, HttpStatus.CREATED);
    }

    @PutMapping("/editCmt/{idCmt}")
    public ResponseEntity<Comment> editCmt(@PathVariable long idCmt, @RequestBody Comment comment){
        Optional<Comment> commentOptional = commentService.findById(idCmt);
        if (!commentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            comment.setIdComment(commentOptional.get().getIdComment());
            comment = commentService.saveCMT(comment);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteCmt/{idCmt}")
    public ResponseEntity<Comment> deleteCmt(@PathVariable long idCmt){
            commentService.deleteCMT(idCmt);
            return new ResponseEntity<>(new Comment(),HttpStatus.OK);
    }





}

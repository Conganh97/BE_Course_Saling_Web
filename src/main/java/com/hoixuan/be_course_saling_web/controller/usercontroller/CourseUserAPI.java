package com.hoixuan.be_course_saling_web.controller.usercontroller;

import com.hoixuan.be_course_saling_web.model.Course;
import com.hoixuan.be_course_saling_web.model.dto.Criteria;
import com.hoixuan.be_course_saling_web.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class CourseUserAPI {
    @Autowired
    CourseService courseService;

    @GetMapping("/courseCriteria")
    public List<Course> getAllCourseByCriteria(@RequestBody Criteria criteria){
        criteria.setNameCourse("%"+criteria.getNameCourse()+"%");
        criteria.setNameInstructor("%"+criteria.getNameInstructor()+"%");
        return courseService.getAllCourseByCriteria(criteria.getNameCourse(),criteria.getFrom(), criteria.getTo(),criteria.getExperience(), criteria.getNameInstructor(), criteria.getRating());
    }
}

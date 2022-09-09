package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.Instructor;
import com.hoixuan.be_course_saling_web.repository.IInstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    IInstructorRepo iInstructorRepo;
    public List<Instructor> getAll(){
        return (List<Instructor>) iInstructorRepo.findAll();
    }

    public Iterable<Instructor> findAll() {
        return iInstructorRepo.findAll();
    }
}

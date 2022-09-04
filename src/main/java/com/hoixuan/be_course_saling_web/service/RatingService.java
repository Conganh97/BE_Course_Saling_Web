package com.hoixuan.be_course_saling_web.service;
import com.hoixuan.be_course_saling_web.model.Rating;
import com.hoixuan.be_course_saling_web.repository.IRatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    final
    IRatingRepo iRatingRepo;
    public Page<Rating> getAll(Pageable pageable){
        return iRatingRepo.findAll(pageable);
    }
    public RatingService(IRatingRepo iRatingRepo) {
        this.iRatingRepo = iRatingRepo;
    }
    public List<Rating> getAllByCourseId(long id){
        return iRatingRepo.getAllByCourseIdCourse(id);
    }
    public Rating findById(long id){
        return iRatingRepo.findById(id).get();
    }
    public Rating save(Rating rating){
        return iRatingRepo.save(rating);
    }
    public void delete(long id){
        iRatingRepo.deleteById(id);
    }
}

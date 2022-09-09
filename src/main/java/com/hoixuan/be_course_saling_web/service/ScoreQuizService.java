package com.hoixuan.be_course_saling_web.service;

import com.hoixuan.be_course_saling_web.model.ScoreQuiz;
import com.hoixuan.be_course_saling_web.repository.IScoreQuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreQuizService {
    @Autowired
    IScoreQuizRepo iScoreQuizRepo;

    public List<ScoreQuiz> getAllByIdQuiz(long id) {
        return iScoreQuizRepo.findAllByQuiz_IdQuiz(id);
    }

    public ScoreQuiz save(ScoreQuiz scoreQuiz) {
        return iScoreQuizRepo.save(scoreQuiz);
    }
}

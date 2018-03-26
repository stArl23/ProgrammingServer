package com.huidi.spring.boot.initializer.service;

import com.huidi.spring.boot.initializer.domain.Quiz;
import com.huidi.spring.boot.initializer.dto.QuizDto;
import com.huidi.spring.boot.initializer.vo.AnswerOutput;

import java.util.List;

public interface QuizService {
    public Quiz save(Quiz quiz);

    //根据id查找quiz并转化为dto返回
    public QuizDto findById(String id);

    //根据title 查找quiz并转化为dto返回
    public List<QuizDto> findByTitleLike(String title);

    //根据传入ids 和对应答案来判断最后给出答案列表和分数
    public AnswerOutput checkAnswers(String uid, String qid, String answers);

}

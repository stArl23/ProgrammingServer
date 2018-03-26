package com.huidi.spring.boot.initializer.service;

import com.huidi.spring.boot.initializer.domain.Question;
import com.huidi.spring.boot.initializer.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    //保存question
    public Question save(Question question);

    //根据id查找question返回dto
    public QuestionDto findById(String id);

    public List<QuestionDto> findByIds(String ids);
}

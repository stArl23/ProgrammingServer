package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.convert.QuestionConverter;
import com.huidi.spring.boot.initializer.dao.QuestionDao;
import com.huidi.spring.boot.initializer.domain.Question;
import com.huidi.spring.boot.initializer.dto.QuestionDto;
import com.huidi.spring.boot.initializer.service.QuestionService;
import com.huidi.spring.boot.initializer.utils.KeyUtils;
import com.huidi.spring.boot.initializer.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    @Override
    public Question save(Question question) {

        if (StringUtils.isEmpty(question.getId()))
            question.setId(KeyUtils.genUniqueKey());
        return questionDao.save(question);
    }

    @Override
    public QuestionDto findById(String id) {
        Question question = questionDao.findOne(id);
        if (question == null)
            //TODO
            throw new RuntimeException();
        return QuestionConverter.convertQuestion2Dto(question);
    }

    @Override
    public List<QuestionDto> findByIds(String ids) {
        List<Question> questions = questionDao.findAllByIdIn(
                StringUtils.string2List(ids));
        return QuestionConverter.convertQuestion2Dto(questions);
    }
}

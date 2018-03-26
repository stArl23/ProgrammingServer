package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.dto.QuizDto;
import com.huidi.spring.boot.initializer.service.QuizService;
import com.huidi.spring.boot.initializer.vo.AnswerOutput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class QuizServiceImplTest {
    @Autowired
    private QuizService quizService;

    @Test
    public void findByTitleLike() throws Exception {
        List<QuizDto> quizDtos = quizService.findByTitleLike("p");
        Assert.assertEquals(2, quizDtos.size());
    }

    @Test
    @Transactional
    public void checkAnswers() throws Exception {
        AnswerOutput answerOutput = quizService.checkAnswers("1", "1521550979889221111", "A&D");
        Assert.assertNotNull(answerOutput);
    }

    @Test
    public void findById() throws Exception {
        QuizDto quizDto = quizService.findById("1521550979889221111");
        Assert.assertNotNull(quizDto);
    }

}
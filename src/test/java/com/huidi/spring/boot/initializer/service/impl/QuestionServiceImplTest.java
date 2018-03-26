package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.domain.Question;
import com.huidi.spring.boot.initializer.dto.QuestionDto;
import com.huidi.spring.boot.initializer.service.QuestionService;
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
public class QuestionServiceImplTest {
    @Autowired
    private QuestionService questionService;

    @Test
    public void findByIds() throws Exception {
        List<QuestionDto> questions = questionService.findByIds("1521551004853669000&1521551004836359709");
        Assert.assertEquals(2, questions.size());
    }

    @Test
    @Transactional
    public void save() throws Exception {
        Question q1 = new Question(), q2 = new Question(), q3 = new Question(), q4 = new Question();
        q1.setAnswer("C");
        q1.setDescription("Python使用缩进作为语法边界,一般建议怎样缩进?");
        q1.setItems("A.TAB&" +
                "B.两个空格&" +
                "C.四个空格&" +
                "D.八个空格");
        q2.setAnswer("D");
        q2.setDescription("一般建议使用Python哪个版本作为产生环境?");
        q2.setItems("A.Python 2.5.*&" +
                "B.Python 2.6.*&" +
                "C.Python 2.7.*&" +
                "D.Python 3.*");

        q3.setAnswer("B");
        q3.setDescription("print 100 - 25 * 3 % 4 应该输出什么?");
        q3.setItems("A.1&" +
                "B.97&" +
                "C.25&" +
                "D.0");

        q4.setAnswer("D");
        q4.setDescription("要将 3.1415926 变成 00003.14 如何进行格式化输出?");
        q4.setItems("A.\"%.2f\"% 3.1415629&" +
                "B.\"%8.2f\"% 3.1415629&" +
                "C.\"%0.2f\"% 3.1415629&" +
                "D.\"%08.2f\"% 3.1415629");
        questionService.save(q1);
        questionService.save(q2);
        questionService.save(q3);
        questionService.save(q4);
    }

    @Test
    public void findById() throws Exception {
        QuestionDto question = questionService.findById("1521551004853669000");
        Assert.assertNotNull(question);
    }

}
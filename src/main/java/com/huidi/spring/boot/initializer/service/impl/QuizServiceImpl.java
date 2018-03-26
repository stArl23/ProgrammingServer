package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.convert.QuizConverter;
import com.huidi.spring.boot.initializer.dao.QuestionDao;
import com.huidi.spring.boot.initializer.dao.QuizDao;
import com.huidi.spring.boot.initializer.dao.StatisticsDao;
import com.huidi.spring.boot.initializer.dao.UserDao;
import com.huidi.spring.boot.initializer.domain.Question;
import com.huidi.spring.boot.initializer.domain.Quiz;
import com.huidi.spring.boot.initializer.domain.Statistics;
import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.dto.QuizDto;
import com.huidi.spring.boot.initializer.enums.QuizEnums;
import com.huidi.spring.boot.initializer.enums.UserEnums;
import com.huidi.spring.boot.initializer.exception.QuizException;
import com.huidi.spring.boot.initializer.exception.UserException;
import com.huidi.spring.boot.initializer.service.QuestionService;
import com.huidi.spring.boot.initializer.service.QuizService;
import com.huidi.spring.boot.initializer.utils.KeyUtils;
import com.huidi.spring.boot.initializer.utils.StatisticsUtils;
import com.huidi.spring.boot.initializer.utils.StringUtils;
import com.huidi.spring.boot.initializer.vo.AnswerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizDao quizDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private StatisticsDao statisticsDao;

    @Autowired
    private QuestionService questionService;

    @Override
    public Quiz save(Quiz quiz) {
        if (StringUtils.isEmpty(quiz.getId()))
            quiz.setId(KeyUtils.genUniqueKey());
        return quizDao.save(quiz);
    }

    @Override
    public List<QuizDto> findByTitleLike(String title) {
        List<Quiz> quizzes = quizDao.findAllByTitleContains(title);
        List<QuizDto> quizDtos = new ArrayList<>();
        quizDtos = quizzes.stream().map(
                e -> QuizConverter.convert(e, questionService.findByIds(e.getQuestions())))
                .collect(Collectors.toList());
        return quizDtos;
    }

    @Override
    public AnswerOutput checkAnswers(String uid, String qid, String answers) {
        //查看user是否存在
        User user = userDao.findOne(Integer.parseInt(uid));
        if (user == null)
            throw new UserException(UserEnums.USER_NOT_EXISTS);
        //查看quiz是否存在并查询id,存在则返回答案
        Quiz quiz = quizDao.findOne(qid);
        if (quiz == null)
            throw new QuizException(QuizEnums.QUIZ_EMPTY);
        if (quiz.getQuestions() != null
                && quiz.getQuestions().length()
                == answers.length())
            throw new QuizException(QuizEnums.QUESTIONS_EMPTY_OR_LENGTH_ERROR);
        List<Question> questionList = questionDao.
                findAllByIdIn(StringUtils.string2List(quiz.getQuestions()));
        //对答案并给出分数
        List<String> correctAnswers = questionList.stream()
                .map(e -> e.getAnswer())
                .collect(Collectors.toList());
        List<String> currentAnswers = StringUtils.string2List(answers);
        Integer totalMarks = currentAnswers.size();
        Integer currentMarks = getCurrentMarks(correctAnswers, currentAnswers);
        //将记录存入数据库便于后序分析
        //TODO
        Statistics statistics = StatisticsUtils.createStatistics(Integer.parseInt(uid), quiz.getId()
                , answers, totalMarks, currentMarks);
        statisticsDao.save(statistics);
        //返回answeroutput
        AnswerOutput answerOutput = new AnswerOutput();
        answerOutput.setCorrectAnswer(correctAnswers);
        answerOutput.setFullMarks(totalMarks);
        answerOutput.setCurrentMarks(currentMarks);
        return answerOutput;
    }

    @Override
    public QuizDto findById(String id) {
        Quiz quiz = quizDao.findOne(id);
        if (quiz == null)
            throw new RuntimeException();
        return QuizConverter.convert(quiz, questionService.findByIds(quiz.getQuestions()));
    }

    /**
     * 得到现在的分数
     *
     * @param correctAnswers
     * @param currentAnswers
     * @return
     */
    private Integer getCurrentMarks(List<String> correctAnswers,
                                    List<String> currentAnswers) {
        int currentMarks = 0;
        for (int i = 0; i < correctAnswers.size(); i++) {
            if (correctAnswers.get(i).equals(currentAnswers.get(i)))
                currentMarks++;
        }
        return currentMarks;
    }
}

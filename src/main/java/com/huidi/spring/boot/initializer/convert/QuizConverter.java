package com.huidi.spring.boot.initializer.convert;

import com.huidi.spring.boot.initializer.domain.Quiz;
import com.huidi.spring.boot.initializer.dto.QuestionDto;
import com.huidi.spring.boot.initializer.dto.QuizDto;

import java.util.List;

public class QuizConverter {

    public static QuizDto convert(Quiz quiz, List<QuestionDto> questionDtos) {
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setTitle(quiz.getTitle());
        quizDto.setQuestions(questionDtos);
        return quizDto;
    }
}

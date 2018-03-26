package com.huidi.spring.boot.initializer.controller;

import com.huidi.spring.boot.initializer.dto.QuizDto;
import com.huidi.spring.boot.initializer.enums.CommonEnums;
import com.huidi.spring.boot.initializer.exception.CommonException;
import com.huidi.spring.boot.initializer.from.AnswerForm;
import com.huidi.spring.boot.initializer.service.QuizService;
import com.huidi.spring.boot.initializer.vo.AnswerOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/{id}")
    public QuizDto getQuizDto(@PathVariable("id") String id) {
        return quizService.findById(id);
    }

    @PostMapping("/answer")
    public AnswerOutput getAnswers(@Valid AnswerForm answerForm
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new CommonException(CommonEnums.PARAM_INVALID);
        return quizService.checkAnswers(answerForm.getUid()
                , answerForm.getQid()
                , answerForm.getAnswers());
    }
}

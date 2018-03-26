package com.huidi.spring.boot.initializer.exception;

import com.huidi.spring.boot.initializer.enums.QuizEnums;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizException extends RuntimeException {
    private String message;

    public QuizException(String message) {
        super(message);

    }

    public QuizException(QuizEnums quizEnums) {
        super(quizEnums.getMessage());
        this.message = quizEnums.getMessage();
    }

}

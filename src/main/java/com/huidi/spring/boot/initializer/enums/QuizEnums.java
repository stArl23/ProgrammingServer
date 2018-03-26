package com.huidi.spring.boot.initializer.enums;

import lombok.Getter;

@Getter
public enum QuizEnums {

    QUESTIONS_EMPTY_OR_LENGTH_ERROR(61, "问题为空或长度不变"),
    QUIZ_EMPTY(62, "问卷为空");

    private Integer id;
    private String message;

    QuizEnums(Integer id, String message) {
        this.id = id;
        this.message = message;
    }
}

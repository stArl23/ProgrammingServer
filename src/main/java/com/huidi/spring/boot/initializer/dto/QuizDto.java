package com.huidi.spring.boot.initializer.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuizDto {
    private String id;
    private String title;
    private List<QuestionDto> questions;

    public QuizDto() {
    }
}

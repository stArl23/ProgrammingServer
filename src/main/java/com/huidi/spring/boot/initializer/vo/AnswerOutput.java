package com.huidi.spring.boot.initializer.vo;

import lombok.Data;

import java.util.List;

@Data
public class AnswerOutput {

    private Integer fullMarks;
    private Integer currentMarks;
    private List<String> correctAnswer;

    public AnswerOutput() {
    }
}

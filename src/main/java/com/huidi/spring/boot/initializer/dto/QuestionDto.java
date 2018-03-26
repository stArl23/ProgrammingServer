package com.huidi.spring.boot.initializer.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto {
    private String id;
    private String desc;
    private List<String> items;

    public QuestionDto() {
    }
}

package com.huidi.spring.boot.initializer.from;

import lombok.Data;

@Data
public class AnswerForm {
    private String uid;
    private String qid;
    private String answers;

    public AnswerForm() {
    }
}

package com.huidi.spring.boot.initializer.vo;

import lombok.Data;

@Data
public class CommonOutput {
    private Integer id;
    private Boolean flag;
    private String message;

    public CommonOutput() {
    }
}

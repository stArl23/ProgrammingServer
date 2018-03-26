package com.huidi.spring.boot.initializer.enums;

import lombok.Getter;

@Getter
public enum CommonEnums {
    PARAM_INVALID(50, "参数有误");

    private Integer id;
    private String message;

    CommonEnums(Integer id, String message) {
        this.id = id;
        this.message = message;
    }
}

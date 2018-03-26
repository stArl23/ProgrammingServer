package com.huidi.spring.boot.initializer.enums;

import lombok.Getter;

@Getter
public enum ProgramEnums {

    PROGRAM_SAVE_ERROR(20, "程序保存出错！"),
    PROGRAM_NOT_EXISTS(21, "程序不存在"),
    PROGRAM_EXISTS(22, "用户已存在");

    private Integer id;
    private String message;

    ProgramEnums(Integer id, String message) {
        this.id = id;
        this.message = message;
    }
}

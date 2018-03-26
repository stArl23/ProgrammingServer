package com.huidi.spring.boot.initializer.enums;


import lombok.Getter;

@Getter
public enum CourseEnums {
    COURSE_NOT_EXISTS(40, "课程不存在"),
    COURSE_SAVE_ERROR(41, "课程保存失败");
    private Integer id;
    private String message;

    CourseEnums(Integer id, String message) {
        this.id = id;
        this.message = message;
    }
}

package com.huidi.spring.boot.initializer.exception;

import com.huidi.spring.boot.initializer.enums.CourseEnums;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseException extends RuntimeException {
    private String message;

    public CourseException(String message) {
        this.message = message;
    }

    public CourseException(CourseEnums courseEnums) {
        super(courseEnums.getMessage());
        this.message = courseEnums.getMessage();
    }
}

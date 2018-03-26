package com.huidi.spring.boot.initializer.exception;

import com.huidi.spring.boot.initializer.enums.CommonEnums;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommonException extends RuntimeException {
    private String message;

    public CommonException(String message) {
        super(message);
    }

    public CommonException(CommonEnums commonEnums) {
        super(commonEnums.getMessage());
        this.message = commonEnums.getMessage();
    }
}

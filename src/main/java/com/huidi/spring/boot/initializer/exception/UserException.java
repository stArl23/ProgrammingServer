package com.huidi.spring.boot.initializer.exception;

import com.huidi.spring.boot.initializer.enums.UserEnums;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends RuntimeException {
    private String message;

    public UserException(String message) {
        super(message);
    }

    public UserException(UserEnums userEnums) {
        super(userEnums.getMessage());
        this.message = userEnums.getMessage();
    }
}

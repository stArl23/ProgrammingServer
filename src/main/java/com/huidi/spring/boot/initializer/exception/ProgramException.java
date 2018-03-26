package com.huidi.spring.boot.initializer.exception;

import com.huidi.spring.boot.initializer.enums.ProgramEnums;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProgramException extends RuntimeException {
    private String message;

    public ProgramException(String message) {
        super(message);
    }

    public ProgramException(ProgramEnums programEnums) {
        super(programEnums.getMessage());
        this.message = programEnums.getMessage();
    }
}

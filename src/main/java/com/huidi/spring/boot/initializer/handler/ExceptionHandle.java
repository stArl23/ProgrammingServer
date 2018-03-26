package com.huidi.spring.boot.initializer.handler;


import com.huidi.spring.boot.initializer.exception.*;
import com.huidi.spring.boot.initializer.utils.CommonOutputUtils;
import com.huidi.spring.boot.initializer.vo.CommonOutput;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = UserException.class)
    public CommonOutput UserExceptionHandler(UserException ex) {
        return CommonOutputUtils.failure(ex);
    }

    @ExceptionHandler(value = ProgramException.class)
    public CommonOutput ProgramExceptionHandler(ProgramException ex) {
        return CommonOutputUtils.failure(ex);
    }

    @ExceptionHandler(value = CourseException.class)
    public CommonOutput CourseExceptionHandler(CourseException ex) {
        return CommonOutputUtils.failure(ex);
    }

    @ExceptionHandler(value = CommonException.class)
    public CommonOutput CommonExceptionHandler(CommonException ex) {
        return CommonOutputUtils.failure(ex);
    }

    @ExceptionHandler(value = QuizException.class)
    public CommonOutput QuizExceptionHandler(QuizException ex) {
        return CommonOutputUtils.failure(ex);
    }
}

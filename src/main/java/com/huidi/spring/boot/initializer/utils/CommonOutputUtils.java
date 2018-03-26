package com.huidi.spring.boot.initializer.utils;

import com.huidi.spring.boot.initializer.vo.CommonOutput;

public class CommonOutputUtils {

    public static final String SUCCESS_MESSAGE = "操作成功";

    public static CommonOutput success(Integer id, String message) {
        CommonOutput commonOutput = new CommonOutput();
        commonOutput.setId(id);
        commonOutput.setFlag(Boolean.TRUE);
        commonOutput.setMessage(message);
        return commonOutput;
    }

    public static CommonOutput success() {
        CommonOutput commonOutput = new CommonOutput();
        commonOutput.setFlag(Boolean.TRUE);
        commonOutput.setMessage(SUCCESS_MESSAGE);
        return commonOutput;
    }

    public static CommonOutput failure() {
        CommonOutput commonOutput = new CommonOutput();
        commonOutput.setFlag(Boolean.FALSE);
        return commonOutput;
    }

    public static CommonOutput failure(RuntimeException ex) {
        CommonOutput commonOutput = new CommonOutput();
        commonOutput.setFlag(Boolean.FALSE);
        commonOutput.setMessage(ex.getMessage());
        return commonOutput;
    }
}

package com.huidi.spring.boot.initializer.vo;

import lombok.Data;

@Data
public class UserOutput {
    private Integer id;
    private String username;
    private String description;
    private String avatar;
    private String nickname;

    public UserOutput() {
    }
}

package com.huidi.spring.boot.initializer.from;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UserUpdateForm {
    @NotEmpty
    private String id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String mobilephone;
    @NotEmpty
    private String description;
    @NotEmpty
    private String nickname;
}

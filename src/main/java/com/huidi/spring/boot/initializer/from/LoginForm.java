package com.huidi.spring.boot.initializer.from;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;

    public LoginForm() {
    }
}

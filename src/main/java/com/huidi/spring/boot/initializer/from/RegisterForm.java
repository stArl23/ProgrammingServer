package com.huidi.spring.boot.initializer.from;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class RegisterForm {

    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String confirmPassword;
    @NotEmpty
    private String mobilephone;
   /* @Email
    @NotEmpty
    private  String email;*/

    public RegisterForm() {
    }
}

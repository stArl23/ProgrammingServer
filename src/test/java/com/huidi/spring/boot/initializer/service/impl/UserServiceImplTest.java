package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.from.LoginForm;
import com.huidi.spring.boot.initializer.from.RegisterForm;
import com.huidi.spring.boot.initializer.service.UserService;
import com.huidi.spring.boot.initializer.vo.CommonOutput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void register() throws Exception {
        RegisterForm registerForm = new RegisterForm();
        //registerForm.setEmail("wanghuidi123456@gmail.com");
        registerForm.setMobilephone("13357891210");
        registerForm.setUsername("wanghuidi");
        registerForm.setPassword("1234567");
        registerForm.setConfirmPassword("1234567");
        CommonOutput commonOutput = userService.register(registerForm);
        Assert.assertEquals(commonOutput.getFlag(), Boolean.TRUE);
    }

    @Test
    public void login() throws Exception {
        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("knknkn");
        loginForm.setPassword("123456");
        CommonOutput commonOutput = userService.login(loginForm);
        Assert.assertEquals(commonOutput.getFlag(), Boolean.TRUE);
    }

    @Test
    public void getUsers() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
    }

}
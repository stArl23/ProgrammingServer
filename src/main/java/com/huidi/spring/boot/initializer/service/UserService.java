package com.huidi.spring.boot.initializer.service;

import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.from.LoginForm;
import com.huidi.spring.boot.initializer.from.RegisterForm;
import com.huidi.spring.boot.initializer.from.UserUpdateForm;
import com.huidi.spring.boot.initializer.vo.CommonOutput;
import com.huidi.spring.boot.initializer.vo.UserOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<UserOutput> getUsers();

    UserOutput getUser(Integer id);

    Page<User> getUsers(Pageable pageable);

    CommonOutput register(RegisterForm registerForm);

    CommonOutput login(LoginForm loginForm);

    CommonOutput userUpdate(UserUpdateForm userUpdateForm);

    List<UserOutput> fuzzyQueryUsers(String cond);

    List<UserOutput> getUsersByAttentions(Integer uid);

    CommonOutput deleteAttentionFromUser(Integer uid, Integer id);

    CommonOutput appendAttentionFromUser(Integer uid, Integer id);
}

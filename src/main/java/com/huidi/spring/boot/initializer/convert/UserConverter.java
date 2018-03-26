package com.huidi.spring.boot.initializer.convert;

import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.vo.UserOutput;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserOutput converter(User user) {
        UserOutput userOutput = new UserOutput();
        BeanUtils.copyProperties(user, userOutput);
        return userOutput;
    }

    public static List<UserOutput> converter(List<User> users) {
        List<UserOutput> userOutputs = new ArrayList<>();
        userOutputs = users.stream().map(e -> converter(e)).collect(Collectors.toList());
        return userOutputs;
    }
}

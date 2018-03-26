package com.huidi.spring.boot.initializer.controller;

import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/view/users")
public class UserViewController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    ModelAndView listUsers(@RequestParam(name = "page", defaultValue = "0") Integer page,
                           @RequestParam(name = "size", defaultValue = "5") Integer size,
                           HashMap<String, Object> map) {
        Page<User> users = userService.getUsers(new PageRequest(page, size));
        map.put("users", users);
        map.put("page", page);
        map.put("size", size);
        ModelAndView modelAndView = new ModelAndView("user/list", map);
        return modelAndView;
    }
}

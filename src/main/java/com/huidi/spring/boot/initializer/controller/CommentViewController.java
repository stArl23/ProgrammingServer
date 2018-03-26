package com.huidi.spring.boot.initializer.controller;

import com.huidi.spring.boot.initializer.domain.Comment;
import com.huidi.spring.boot.initializer.service.CommentService;
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
@RequestMapping("/view/comments")
public class CommentViewController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    ModelAndView listComments(@RequestParam(name = "page", defaultValue = "0") Integer page,
                              @RequestParam(name = "size", defaultValue = "5") Integer size,
                              HashMap<String, Object> map) {
        Page<Comment> comments = commentService.getComments(new PageRequest(page, size));
        map.put("comments", comments);
        map.put("page", page);
        map.put("size", size);
        ModelAndView modelAndView = new ModelAndView("comment/list", map);
        return modelAndView;
    }
}

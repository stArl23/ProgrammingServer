package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void getComment() throws Exception {

        System.out.println(commentService.getComment(1));
    }

    @Test
    public void getComments() throws Exception {
        System.out.println(commentService.getComments());
    }

    @Test
    public void insertComment() throws Exception {
        commentService.insertComment(1, 2, 1.1, "wo yao he ya yi de meizi");

    }

}
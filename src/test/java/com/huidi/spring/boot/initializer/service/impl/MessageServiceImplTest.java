package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceImplTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void getMessages() throws Exception {
        System.out.println(messageService.getMessages());
    }

    @Test
    public void getMessagesByUserId() throws Exception {
        System.out.println(messageService.getMessagesByUserId(1));
    }

}
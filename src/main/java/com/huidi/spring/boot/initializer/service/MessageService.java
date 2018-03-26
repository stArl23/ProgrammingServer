package com.huidi.spring.boot.initializer.service;

import com.huidi.spring.boot.initializer.vo.MessageOutput;

import java.util.List;

public interface MessageService {

    public List<MessageOutput> getMessages();

    public List<MessageOutput> getMessagesByUserId(Integer user_id);
}

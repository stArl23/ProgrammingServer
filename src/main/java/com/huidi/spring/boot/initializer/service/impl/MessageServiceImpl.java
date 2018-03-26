package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.dao.MessageDao;
import com.huidi.spring.boot.initializer.domain.Message;
import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.service.MessageService;
import com.huidi.spring.boot.initializer.vo.MessageOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public List<MessageOutput> getMessages() {
        List<MessageOutput> messageOutputs = new ArrayList<>();
        for (Message message : this.messageDao.findAll())
            messageOutputs.add(new MessageOutput(message));
        return messageOutputs;
    }

    @Override
    public List<MessageOutput> getMessagesByUserId(Integer user_id) {
        List<MessageOutput> messageOutputs = new ArrayList<>();
        for (Message message : this.messageDao.findAllByUser(new User(user_id)))
            messageOutputs.add(new MessageOutput(message));
        return messageOutputs;
    }
}

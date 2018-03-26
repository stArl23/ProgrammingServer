package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Message;
import com.huidi.spring.boot.initializer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao extends JpaRepository<Message, Integer> {

    public List<Message> findAllByUser(User user);
}

package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Comment;
import com.huidi.spring.boot.initializer.domain.Program;
import com.huidi.spring.boot.initializer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {
    public Comment findById(Integer id);

    public List<Comment> findAllByProgram(Program program);

    public List<Comment> findALLByUser(User user);
}

package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.dao.CommentDao;
import com.huidi.spring.boot.initializer.domain.Comment;
import com.huidi.spring.boot.initializer.domain.Program;
import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.service.CommentService;
import com.huidi.spring.boot.initializer.vo.CommentOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public CommentOutput getComment(Integer comment_id) {
        Comment comment = this.commentDao.findOne(comment_id);
        return new CommentOutput(comment);
    }

    @Override
    public Page<Comment> getComments(Pageable pageable) {
        return commentDao.findAll(pageable);
    }

    @Override
    public List<CommentOutput> getComments() {
        List<CommentOutput> commentOutputs = new ArrayList<>();
        for (Comment comment : this.commentDao.findAll())
            commentOutputs.add(new CommentOutput(comment));
        return commentOutputs;
    }

    @Override
    public List<CommentOutput> getCommentsByUserId(Integer user_id) {
        List<CommentOutput> commentOutputs = new ArrayList<>();
        for (Comment comment : this.commentDao.findALLByUser(new User(user_id)))
            commentOutputs.add(new CommentOutput(comment));
        return commentOutputs;
    }

    @Override
    public List<CommentOutput> getCommentByProgramId(Integer program_id) {
        List<CommentOutput> commentOutputs = new ArrayList<>();
        for (Comment comment : this.commentDao.findAllByProgram(new Program(program_id)))
            commentOutputs.add(new CommentOutput(comment));
        return commentOutputs;
    }

    @Override
    public void insertComment(Integer program_id, Integer user_id, Double rating, String content) {
        this.commentDao.save(new Comment(new Program(program_id), new User(user_id), new Date(Calendar.getInstance().getTimeInMillis()), rating, content));
    }
}

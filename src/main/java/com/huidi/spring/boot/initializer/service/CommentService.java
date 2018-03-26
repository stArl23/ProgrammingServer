package com.huidi.spring.boot.initializer.service;

import com.huidi.spring.boot.initializer.domain.Comment;
import com.huidi.spring.boot.initializer.vo.CommentOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {

    public CommentOutput getComment(Integer comment_id);

    Page<Comment> getComments(Pageable pageable);

    public List<CommentOutput> getComments();

    public List<CommentOutput> getCommentsByUserId(Integer user_id);

    public List<CommentOutput> getCommentByProgramId(Integer program_id);

    public void insertComment(Integer program_id, Integer user_id, Double rating, String content);
}

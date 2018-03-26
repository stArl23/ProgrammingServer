package com.huidi.spring.boot.initializer.vo;

import com.huidi.spring.boot.initializer.domain.Comment;

import java.io.Serializable;
import java.sql.Date;

public class CommentOutput implements Serializable {
    private Integer id;
    private Integer programid;
    private Integer userid;
    private Date date;
    private Double rating;
    private String content;

    public CommentOutput(Comment comment) {
        this.id = comment.getId();
        this.programid = comment.getProgram().getId();
        this.userid = comment.getUser().getId();
        this.date = comment.getDate();
        this.rating = comment.getRating();
        this.content = comment.getContent();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProgramid() {
        return programid;
    }

    public void setProgramid(Integer programid) {
        this.programid = programid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

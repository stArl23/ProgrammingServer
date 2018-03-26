package com.huidi.spring.boot.initializer.vo;

import com.huidi.spring.boot.initializer.domain.Message;

import java.io.Serializable;
import java.sql.Date;

public class MessageOutput implements Serializable {
    private Integer id;
    private Integer userid;

    private String title;
    private String content;
    private Date date;

    public MessageOutput(Message message) {
        this.id = message.getId();
        this.userid = message.getUser().getId();
        this.title = message.getTitle();
        this.content = message.getContent();
        this.date = message.getDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

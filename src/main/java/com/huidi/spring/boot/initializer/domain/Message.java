package com.huidi.spring.boot.initializer.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String title;
    private String content;
    private Date date;

    public Message(User user, String title, String content, Date date) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Message() {
    }

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    }*/
}

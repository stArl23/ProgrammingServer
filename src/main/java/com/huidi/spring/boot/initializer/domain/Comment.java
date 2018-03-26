package com.huidi.spring.boot.initializer.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne()
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @OneToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    private Date date;
    private Double rating;
    private String content;


    public Comment(Program program, User user, Date date, Double rating, String content) {
        this.program = program;
        this.user = user;
        this.date = date;
        this.rating = rating;
        this.content = content;
    }

    public Comment() {
    }

    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    }*/
}

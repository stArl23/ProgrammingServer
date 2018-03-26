package com.huidi.spring.boot.initializer.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String mobilephone;
    @Email
    private String email;
    private String description;
    private String avatar;
    private String nickname;

    //添加收藏列表，并可以对其进行修改
    private String collections = "";

    //程序列表
    private String programs = "";

    //课程列表
    private String courses = "";

    //关注列表
    private String attentions = "";


    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }
}

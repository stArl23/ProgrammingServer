package com.huidi.spring.boot.initializer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Question {

    @Id
    private String id;
    private String description;
    private String items = "";
    private String answer;

    public Question() {
    }
}

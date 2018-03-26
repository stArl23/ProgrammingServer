package com.huidi.spring.boot.initializer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Quiz {
    @Id
    private String id;
    private String questions = "";
    private String title;

    public Quiz() {
    }
}

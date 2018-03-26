package com.huidi.spring.boot.initializer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
@Data
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String avatar;
    private String author;
    private String title;
    private String image;
    private String content;
    private Double rating;

    private String categoryName;
    private Boolean deleted;

    //
    /*@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name="category_program")
    private List<Category> categories;*/

    private Date date;

    public Program() {
    }

    public Program(Integer id) {
        this.id = id;
    }

}

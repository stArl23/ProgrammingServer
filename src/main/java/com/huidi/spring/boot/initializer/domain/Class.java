package com.huidi.spring.boot.initializer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    /*@ManyToOne()
    @JoinColumn(name="chapterId" , nullable = false)
    private Chapter chapter;*/
    private Integer chapterId;

    public Class() {
    }

   /* public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Class aClass = (Class) o;

        return id.equals(aClass.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}

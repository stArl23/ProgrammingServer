package com.huidi.spring.boot.initializer.vo;

import com.huidi.spring.boot.initializer.domain.Program;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ProgramOutput implements Serializable {
    private Integer id;
    private String avatar;
    private String author;
    private String title;
    private String image;
    private String content;
    private Double rating;
    private List<String> categories;
    private Date date;


    public ProgramOutput() {
    }

    public ProgramOutput(Program program) {
        this.id = program.getId();
        this.avatar = program.getAvatar();
        this.author = program.getAuthor();
        this.title = program.getTitle();
        this.image = program.getImage();
        this.content = program.getContent();
        this.rating = program.getRating();
        this.categories = Arrays.asList(program.getCategoryName());
        this.date = program.getDate();
    }


    /*public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/
}

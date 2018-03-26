package com.huidi.spring.boot.initializer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String cover;
    private String content;
    private String description;
    private Integer rating;

    //添加desc属性，课程简介

    /*@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "category_course")
    private List<Category> categories;*/

    private String categoryName;


  /*  @OneToMany(cascade = CascadeType.ALL,mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Chapter> chapters;*/

    public Course() {
    }

  /*  //添加category
    public void insertCategory(Category category){
        if (!containsCategory(category))
            this.categories.add(category);
    }

    //移除category
    public void removeCategory(Category category){
        if(containsCategory(category))
            this.categories.remove(category);
    }
*/
    //添加chapter
  /*  public void insertChapter(Chapter chapter){
        this.chapters.add(chapter);
    }

    //移除chapter
    public void removeChapter(Chapter chapter){
        this.chapters.remove(chapter);
    }*/

    /*private boolean containsCategory(Category category){
        for(Category category1:this.categories)
            if(category1.getId().equals(category.getId()))return false;
        return true;
    }*/

}

package com.huidi.spring.boot.initializer.vo;

import com.huidi.spring.boot.initializer.domain.Course;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Data
public class CourseOutput implements Serializable {
    private Integer id;

    private String name;
    private String cover;
    private String content;
    private Integer rating;

    private List<String> categories;
    private HashMap<String, List<String>> chapters;

    public CourseOutput(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.cover = course.getCover();
        this.content = course.getContent();
        this.rating = course.getRating();
        this.categories = Arrays.asList(course.getCategoryName());
        this.chapters = new HashMap<String, List<String>>();
        /*for(Chapter chapter:course.getChapters()){
            this.chapters.put(chapter.getChapterName(),new ClassOutput(chapter.getClasses()).getClassName());
        }*/
    }

    public CourseOutput() {
    }
}

package com.huidi.spring.boot.initializer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /* @ManyToMany(mappedBy = "categories",fetch = FetchType.EAGER)
     private List<Course> courses;

     @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
     private List<Program> programs;
 */
    public Category(String name) {
        this.name = name;
    }

    public Category() {
    }

    /*public Integer getId() {
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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }*/

   /* //插入program
    public void insertProgram(Program program){
        if(!containsProgram(program))
            this.programs.add(program);
    }

    //移除course
    public void removeProgram(Program program){
        if(containsProgram(program))
            this.programs.remove(program);
    }

    public boolean containsProgram(Program program){
        for(Program program1:this.programs)
            if(program1.getId().equals(program.getId()))return false;
        return true;
    }

    //插入course
    public void insertCourse(Course course){
        if(!containsCourse(course))
            this.courses.add(course);
    }

    //移除course
    public void removeCourse(Course course){
        if(containsCourse(course))
            this.courses.remove(course);
    }

    //是否contain course
    private boolean containsCourse(Course course){
        for(Course course1:this.courses)
            if(course1.getId().equals(course.getId()))return false;
        return true;
    }*/
}

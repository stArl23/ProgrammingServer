package com.huidi.spring.boot.initializer.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String chapterName;
/*

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "chapter",fetch = FetchType.EAGER)
    private Set<Class> classes;

    @ManyToOne()
    @JoinColumn(name="courseId",nullable = false)
    private Course course;
*/

    private Integer courseId;

    public Chapter() {
    }

   /* public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Set<Class> getClasses() {
        return classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }*/


    //添加一个class
    /*public void insertClass(Class cla){
        this.classes.add(cla);
    }

    //移除一个class
    public void removeClass(Class cla) {
        this.classes.remove(cla);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chapter chapter = (Chapter) o;

        return Id.equals(chapter.Id);
    }

    @Override
    public int hashCode() {
        return Id.hashCode();
    }
}

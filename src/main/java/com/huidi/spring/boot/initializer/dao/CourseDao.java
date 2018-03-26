package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {
    Course findById(Integer id);

   /* @Query("select c from Course c join fetch c.chapters where c.id=(:id)")
    Course findCourseEarly(@Param("id") Integer id);*/

    Page<Course> findAllByCategoryName(String CategoryName, Pageable pageable);

    List<Course> findAllByIdIn(List<Integer> ids);

    //模糊匹配
    @Query("select c from Course c where c.categoryName like CONCAT('%',:cn,'%') " +
            "or c.content like CONCAT('%',:c,'%')" +
            "or c.description like CONCAT('%',:d,'%')" +
            "or c.name like CONCAT('%',:n,'%')")
    List<Course> fuzzyQueryCourses(@Param("cn") String categoryName
            , @Param("c") String content
            , @Param("d") String desc
            , @Param("n") String name);

    //Page<Course> fuzzyQueryCourses(String condition,Pageable pageable);
}

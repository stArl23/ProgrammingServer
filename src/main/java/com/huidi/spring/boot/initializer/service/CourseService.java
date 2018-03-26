package com.huidi.spring.boot.initializer.service;

import com.huidi.spring.boot.initializer.domain.Course;
import com.huidi.spring.boot.initializer.vo.CommonOutput;
import com.huidi.spring.boot.initializer.vo.CourseOutput;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface CourseService {

    //根据id获得course
    CourseOutput getCourse(Integer id);

    //得到所有courses
    List<CourseOutput> getCourses();

    Page<Course> getCourses(Pageable pageable);

    List<CourseOutput> getCourses(String category, Pageable pageable);

    //删除或者添加课程
    CommonOutput deleteCourseFromUser(Integer courseId, Integer userId);

    CommonOutput appendCourseForUser(Integer courseId, Integer userId);

    List<CourseOutput> getCoursesByUserId(Integer userId);

    List<CourseOutput> fuzzyQueryCourses(String cond);
}

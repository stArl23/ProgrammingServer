package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.dao.UserDao;
import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.service.CourseService;
import com.huidi.spring.boot.initializer.service.UserService;
import com.huidi.spring.boot.initializer.vo.CourseOutput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {


    @Autowired
    private CourseService courseService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void deleteCourseFromUser() throws Exception {
        User user = userDao.findOne(1);
        CourseOutput course = courseService.getCourse(1);
        String courses = user.getCourses();
        courseService.deleteCourseFromUser(user.getId(), course.getId());
        Assert.assertNotEquals(courses, user.getCourses());
    }

    @Test
    @Transactional
    public void appendCourseForUser() throws Exception {
        User user = userDao.findOne(2);
        CourseOutput course = courseService.getCourse(1);
        String courses = user.getCourses();
        courseService.appendCourseForUser(course.getId(), user.getId());
        Assert.assertNotEquals(courses, user.getCourses());
    }

    @Test
    public void getCoursesByUserId() throws Exception {
        List<CourseOutput> courseOutputs = courseService.getCoursesByUserId(1);
        Assert.assertNotNull(courseOutputs);
    }


    @Test
    public void getCourse() throws Exception {
        System.out.println(courseService.getCourse(1));
        System.out.println("\n\n\n");
    }

    @Test
    public void getCourses() throws Exception {
        System.out.println(courseService.getCourses());
        System.out.println("\n\n\n");
    }

}
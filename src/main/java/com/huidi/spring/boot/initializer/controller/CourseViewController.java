package com.huidi.spring.boot.initializer.controller;

import com.huidi.spring.boot.initializer.domain.Course;
import com.huidi.spring.boot.initializer.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequestMapping("/view/courses")
public class CourseViewController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    ModelAndView listCourses(@RequestParam(name = "page", defaultValue = "0") Integer page,
                             @RequestParam(name = "size", defaultValue = "5") Integer size,
                             HashMap<String, Object> map) {
        Page<Course> courses = courseService.getCourses(new PageRequest(page, size));
        map.put("courses", courses);
        map.put("page", page);
        map.put("size", size);
        ModelAndView modelAndView = new ModelAndView("course/list", map);
        return modelAndView;
    }

    @GetMapping("/index")
    ModelAndView createCourse(HashMap<String, Object> map) {
        ModelAndView modelAndView = new ModelAndView("course/index", map);
        return modelAndView;
    }
}

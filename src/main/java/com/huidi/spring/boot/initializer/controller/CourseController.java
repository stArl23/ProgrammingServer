package com.huidi.spring.boot.initializer.controller;


import com.huidi.spring.boot.initializer.service.CourseService;
import com.huidi.spring.boot.initializer.vo.CommonOutput;
import com.huidi.spring.boot.initializer.vo.CourseOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping()
    public List<CourseOutput> listCourses(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "5") Integer size,
            @RequestParam(name = "category", required = false, defaultValue = "") String categoryName,
            @RequestParam(name = "orderBy", required = false, defaultValue = "") String orderBy,
            @RequestParam(name = "direction", required = false, defaultValue = "1") Integer direction) {
        Pageable pageable;
        if ("".equals(orderBy))
            pageable = new PageRequest(page, size);
        else
            pageable = direction == 1 ? new PageRequest(page, size, Sort.Direction.ASC, orderBy)
                    : new PageRequest(page, size, Sort.Direction.DESC, orderBy);
        return courseService.getCourses(categoryName, pageable);
    }

    @GetMapping("/{id}")
    public CourseOutput getCourse(@PathVariable(name = "id") Integer id) {
        return courseService.getCourse(id);
    }


    @GetMapping("/user/{userid}")
    public List<CourseOutput> getUserCourses(@PathVariable(name = "userid") Integer userid) {
        return courseService.getCoursesByUserId(userid);
    }

    @GetMapping("/delete/{courseid}/user/{userid}")
    public CommonOutput deleteCourseFromU(@PathVariable("courseid") Integer courseid, @PathVariable("userid") Integer userid) {
        return courseService.deleteCourseFromUser(courseid, userid);
    }

    @GetMapping("/append/{courseid}/user/{userid}")
    public CommonOutput appendCourseFromU(@PathVariable("courseid") Integer courseid, @PathVariable("userid") Integer userid) {
        return courseService.appendCourseForUser(courseid, userid);
    }

    //课程模糊查询
    @GetMapping("/search/{cond}")
    public List<CourseOutput> fuzzyQuery(@PathVariable("cond") String cond) {
        return courseService.fuzzyQueryCourses(cond);
    }
}

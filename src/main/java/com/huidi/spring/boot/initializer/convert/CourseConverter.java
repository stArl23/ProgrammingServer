package com.huidi.spring.boot.initializer.convert;

import com.huidi.spring.boot.initializer.domain.Course;
import com.huidi.spring.boot.initializer.vo.CourseOutput;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CourseConverter {
    public static CourseOutput converter(Course course) {
        CourseOutput courseOutput = new CourseOutput();
        BeanUtils.copyProperties(course, courseOutput, "chapters");
        courseOutput.setCategories(Arrays.asList(course.getCategoryName()));
        return courseOutput;
    }

    public static List<CourseOutput> converter(List<Course> courses) {
        List<CourseOutput> courseOutputs = new ArrayList<>();
        courseOutputs = courses.stream()
                .map(e -> converter(e))
                .collect(Collectors.toList());
        return courseOutputs;
    }
}

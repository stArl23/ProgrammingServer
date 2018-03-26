package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.convert.CourseConverter;
import com.huidi.spring.boot.initializer.dao.ChapterDao;
import com.huidi.spring.boot.initializer.dao.ClassDao;
import com.huidi.spring.boot.initializer.dao.CourseDao;
import com.huidi.spring.boot.initializer.dao.UserDao;
import com.huidi.spring.boot.initializer.domain.Chapter;
import com.huidi.spring.boot.initializer.domain.Course;
import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.enums.CourseEnums;
import com.huidi.spring.boot.initializer.enums.UserEnums;
import com.huidi.spring.boot.initializer.exception.CourseException;
import com.huidi.spring.boot.initializer.exception.UserException;
import com.huidi.spring.boot.initializer.service.CourseService;
import com.huidi.spring.boot.initializer.utils.CommonOutputUtils;
import com.huidi.spring.boot.initializer.utils.StringUtils;
import com.huidi.spring.boot.initializer.vo.CommonOutput;
import com.huidi.spring.boot.initializer.vo.CourseOutput;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ChapterDao chapterDao;

    @Autowired
    private ClassDao classDao;

    @Autowired
    private UserDao userDao;

    @Override
    public CourseOutput getCourse(Integer id) {
        Course course = courseDao.findOne(id);
        return getFullCourseOutput(course);
    }

    @Override
    public List<CourseOutput> getCourses() {
        List<CourseOutput> courseOutputs = new ArrayList<>();
        for (Course course : courseDao.findAll())
            courseOutputs.add(getFullCourseOutput(course));
        return courseOutputs;
    }

    @Override
    public Page<Course> getCourses(Pageable pageable) {
        return courseDao.findAll(pageable);
    }

    @Override
    public List<CourseOutput> getCourses(String category, Pageable pageable) {
        List<CourseOutput> courseOutputs = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        if ("".equals(category))
            courses = courseDao.findAll(pageable).getContent();
        else
            courses = courseDao.findAllByCategoryName(category, pageable).getContent();
        for (Course course : courses)
            courseOutputs.add(getFullCourseOutput(course));
        return courseOutputs;
    }

    /**
     * 退出课程
     *
     * @param courseId
     * @param userId
     * @return
     */
    @Override
    public CommonOutput deleteCourseFromUser(Integer courseId, Integer userId) {
        Course program = courseDao.findOne(courseId);
        User user = userDao.findById(userId);
        //确保program 和 user对象均存在
        notEmptyCourseAndUser(program, user);

        //items和判断程序是否由该用户
        String ids = StringUtils.deleteItem(user.getCourses(), String.valueOf(courseId));
        if (ids.equals(user.getCourses()))
            throw new UserException(UserEnums.USER_COURSE_ERROR);
        saveTargetUser(user, ids);
        return CommonOutputUtils.success(null, "退出课程成功");
    }

    /**
     * 添加课程
     *
     * @param courseId
     * @param userId
     * @return
     */
    @Override
    public CommonOutput appendCourseForUser(Integer courseId, Integer userId) {
        Course program = courseDao.findOne(courseId);
        User user = userDao.findById(userId);
        //确保course 和 user对象均存在
        notEmptyCourseAndUser(program, user);

        //items和判断程序是否由该用户
        String ids = StringUtils.appendItem(user.getCourses(), String.valueOf(courseId));
        if (ids.equals(user.getCourses()))
            throw new UserException(UserEnums.USER_COURSE_ERROR);
        saveTargetUser(user, ids);
        return CommonOutputUtils.success(null, "加入课程成功");
    }

    /**
     * 模糊查询
     * 匹配字段 description,name,content,categoryName
     *
     * @param cond
     * @return
     */
    @Override
    public List<CourseOutput> fuzzyQueryCourses(String cond) {
        return CourseConverter.converter(
                courseDao.fuzzyQueryCourses(cond, cond, cond, cond));
    }

    @Override
    public List<CourseOutput> getCoursesByUserId(Integer userId) {
        User user = userDao.findById(userId);
        if (!ObjectUtils.allNotNull(user))
            throw new CourseException(CourseEnums.COURSE_NOT_EXISTS);
        return findAllCoursesByIds(user.getCourses());
    }


    //判用户和课程均存在
    private void notEmptyCourseAndUser(Course course, User user) {
        if (!ObjectUtils.allNotNull(course, user))
            throw new UserException(UserEnums.USER_OR_COURSE_EMPTY);
    }


    //判断target user 是否存储成功
    private void saveTargetUser(User user, String ids) {
        user.setCourses(ids);
        user = userDao.save(user);
        if (!ObjectUtils.allNotNull(user))
            throw new UserException(UserEnums.USER_SAVE_ERROR);
    }

    private List<CourseOutput> findAllCoursesByIds(String ids) {
        List<Integer> ids1 = StringUtils.string2List(
                ids).stream()
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
        List<CourseOutput> courses = courseDao.findAllByIdIn(ids1).stream()
                .map(e -> CourseConverter.converter(e))
                .collect(Collectors.toList());
        return courses;
    }

    //得到完整的course映射
    private CourseOutput getFullCourseOutput(Course course) {
        CourseOutput courseOutput = CourseConverter.converter(course);
        HashMap<String, List<String>> chaptersClasses = new HashMap<>();
        //获得course下的每一个chapter
        List<Chapter> chapters = chapterDao.findAllByCourseId(course.getId());
        if (!CollectionUtils.isEmpty(chapters)) {
            for (Chapter c : chapters) {
                //获得chapters 下的每一个classes name
                List<String> classesNames = classDao
                        .findAllByChapterId(c.getId())
                        .stream().map(e -> e.getName())
                        .collect(Collectors.toList());
                chaptersClasses.put(c.getChapterName(), classesNames);
            }
        }
        courseOutput.setChapters(chaptersClasses);
        return courseOutput;
    }
}

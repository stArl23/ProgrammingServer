package com.huidi.spring.boot.initializer.dao;

import com.huidi.spring.boot.initializer.domain.Program;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramDaoTest {

    @Autowired
    ProgramDao programDao;

    @Autowired
    CategoryDao categoryDao;

    @Test
    public void fuzzyQueryPrograms() throws Exception {
        List<Program> programList = programDao.fuzzyQueryPrograms("python", "python", "python", "python");
        Assert.assertNotNull(programList);
    }

    @Test
    public void fuzzyQueryPrograms1() throws Exception {
    }


    @Test
    public void findAllByCategoriesIn() throws Exception {

        Page<Program> programs = programDao.findAllByCategoryNameAndDeletedIsFalse("python", new PageRequest(0, 10));
        Assert.assertEquals(4L, programs.getTotalElements());
    }

}
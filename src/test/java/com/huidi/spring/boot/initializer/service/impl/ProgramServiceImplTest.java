package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.dao.UserDao;
import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.service.ProgramService;
import com.huidi.spring.boot.initializer.service.UserService;
import com.huidi.spring.boot.initializer.vo.ProgramOutput;
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
public class ProgramServiceImplTest {

    @Autowired
    private ProgramService programService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    public void deleteProgramFromUser() throws Exception {
        User user = userDao.findOne(1);
        ProgramOutput program = programService.getProgram(1);
        String programs = user.getPrograms();
        programService.deleteProgramFromUser(1, 1);
        Assert.assertTrue(!user.getPrograms().contains(String.valueOf(1)));
    }

    @Test
    @Transactional
    public void appendProgramForUser() throws Exception {
        User user = userDao.findOne(1);
        ProgramOutput program = programService.getProgram(2);
        programService.appendProgramForUser(2, 1);
        Assert.assertTrue(user.getPrograms().contains(String.valueOf(2)));
    }

    @Test
    @Transactional
    public void deleteCollectionFromUser() throws Exception {
        User user = userDao.findOne(1);
        ProgramOutput program = programService.getProgram(1);
        String programs = user.getPrograms();
        programService.deleteCollectionFromUser(1, 1);
        Assert.assertTrue(!user.getCollections().contains(String.valueOf(1)));
    }

    @Test
    @Transactional
    public void appendCollectionForUser() throws Exception {
        User user = userDao.findOne(1);
        ProgramOutput program = programService.getProgram(2);
        programService.appendCollectionForUser(2, 1);
        Assert.assertTrue(user.getCollections().contains(String.valueOf(2)));
    }

    @Test
    public void getCollectionsByUserId() throws Exception {
        List<ProgramOutput> programOutputList = programService.getCollectionsByUserId(1);
        Assert.assertNotNull(programOutputList);
    }

    @Test
    public void getProgramsByUserId() throws Exception {
        List<ProgramOutput> programOutputList = programService.getProgramsByUserId(1);
        Assert.assertNotNull(programOutputList);
    }


    @Test
    public void getPrograms() throws Exception {
        System.out.println(programService.getPrograms());
        System.out.println("\n\n\n");
    }

    @Test
    public void getProgram() throws Exception {
        System.out.println(programService.getProgram(1));
        System.out.println("\n\n\n");
    }

}
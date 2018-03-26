package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.convert.ProgramConverter;
import com.huidi.spring.boot.initializer.dao.ProgramDao;
import com.huidi.spring.boot.initializer.dao.UserDao;
import com.huidi.spring.boot.initializer.domain.Program;
import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.enums.ProgramEnums;
import com.huidi.spring.boot.initializer.enums.UserEnums;
import com.huidi.spring.boot.initializer.exception.ProgramException;
import com.huidi.spring.boot.initializer.exception.UserException;
import com.huidi.spring.boot.initializer.service.ProgramService;
import com.huidi.spring.boot.initializer.utils.CommonOutputUtils;
import com.huidi.spring.boot.initializer.utils.StringUtils;
import com.huidi.spring.boot.initializer.vo.CommonOutput;
import com.huidi.spring.boot.initializer.vo.ProgramOutput;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    private ProgramDao programDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<ProgramOutput> getPrograms() {
        List<ProgramOutput> programOutputs = new ArrayList<>();
        for (Program program : programDao.findAll())
            programOutputs.add(new ProgramOutput(program));
        return programOutputs;
    }

    @Override
    public Page<Program> getPrograms(Pageable pageable) {
        return programDao.findAll(pageable);
    }

    @Override
    public List<ProgramOutput> getPrograms(String categoryName, Pageable pageable) {
        List<ProgramOutput> programOutputs = new ArrayList<>();
        List<Program> programs = new ArrayList<>();
        if ("".equals(categoryName))
            programs = programDao.findAllByDeletedIsFalse(pageable).getContent();
        else
            programs = programDao.findAllByCategoryNameAndDeletedIsFalse(categoryName, pageable).getContent();
        programOutputs = ProgramConverter.converter(programs);
      /*  for(Program program:programs)
            if(program.getDeleted().equals(Boolean.FALSE))
                programOutputs.add(new ProgramOutput(program));*/
        return programOutputs;
    }

    @Override
    public ProgramOutput getProgram(Integer id) {
        Program program = programDao.findOne(id);
        validProgram(program);
        return ProgramConverter.converter(program);
    }

    /**
     * 删除用户自己编写的program(保存原始数据，仅仅清楚用户和program之间的关系)
     *
     * @param programId
     * @param userId
     * @return
     */
    @Override
    public CommonOutput deleteProgramFromUser(Integer programId, Integer userId) {
        Program program = programDao.findOne(programId);
        User user = userDao.findById(userId);
        //确保program 和 user对象均存在
        notEmptyProgramAndUser(program, user);
        //确保program不是被删除的
        validProgram(program);
        program.setDeleted(Boolean.TRUE);
        //删除items和判断程序是否由该用户编写
        String ids = StringUtils.deleteItem(user.getPrograms(), String.valueOf(programId));
        if (ids.equals(user.getPrograms()))
            throw new UserException(UserEnums.USER_PROGRAM_ERROR);
        user.setPrograms(ids);
        saveTargetUser(user, ids);
        saveTargetProgram(program);
        //操作关注该用户的其他用户
        List<User> users = userDao.findAllByCollectionsContains(programId);
        for (User u : users) {
            u.setCollections(
                    StringUtils.deleteItem(
                            u.getCollections(), String.valueOf(programId)));
            u = userDao.save(u);
            //如果保存失败即u为null时抛出错误
            if (!ObjectUtils.allNotNull(u)) throw new UserException(UserEnums.USER_SAVE_ERROR);
        }
        return CommonOutputUtils.success(null, "用戶删除程序成功");
    }

    /**
     * 添加用户自己写的程序并存储
     *
     * @param programId
     * @param userId
     * @return
     */
    @Override
    public CommonOutput appendProgramForUser(Integer programId, Integer userId) {
        Program program = programDao.findOne(programId);
        User user = userDao.findById(userId);

        //确保program 和 user对象均存在
        notEmptyProgramAndUser(program, user);
        //确保program不是被删除的
        validProgram(program);
        String ids = StringUtils.appendItem(user.getPrograms(), String.valueOf(programId));
        if (ids.equals(user.getPrograms()))
            throw new ProgramException(ProgramEnums.PROGRAM_EXISTS);
        user.setPrograms(ids);
        saveTargetUser(user, ids);
        return CommonOutputUtils.success(null, "用戶添加程序成功");
    }


    /**
     * 取消关注该程序
     *
     * @param programId
     * @param userId
     * @return
     */
    @Override
    public CommonOutput deleteCollectionFromUser(Integer programId, Integer userId) {
        Program program = programDao.findOne(programId);
        User user = userDao.findById(userId);
        //确保program 和 user对象均存在
        notEmptyProgramAndUser(program, user);
        //确保program不是被删除的
        validProgram(program);
        //删除items和判断程序是否由该用户关注
        String ids = StringUtils.deleteItem(user.getCollections(), String.valueOf(programId));
        if (ids.equals(user.getCollections()))
            throw new UserException(UserEnums.USER_COLLECTION_ERROR);
        user.setCollections(ids);
        saveTargetUser(user, ids);
        return CommonOutputUtils.success(null, "用戶取消关注成功");
    }

    /**
     * 关注该程序
     *
     * @param programId
     * @param userId
     * @return
     */
    @Override
    public CommonOutput appendCollectionForUser(Integer programId, Integer userId) {
        Program program = programDao.findOne(programId);
        User user = userDao.findById(userId);
        //确保program 和 user对象均存在
        notEmptyProgramAndUser(program, user);
        //确保program不是被删除的
        validProgram(program);
        //删除items和判断程序是否由该用户关注
        String ids = StringUtils.appendItem(user.getCollections(), String.valueOf(programId));
        if (ids.equals(user.getCollections()))
            throw new UserException(UserEnums.USER_COLLECTION_ERROR);
        user.setCollections(ids);
        saveTargetUser(user, ids);
        return CommonOutputUtils.success(null, "用戶关注成功");
    }


    /**
     * 查找所有用戶收藏的程序
     *
     * @param userId
     * @return
     */
    @Override
    public List<ProgramOutput> getCollectionsByUserId(Integer userId) {
        User user = userDao.findById(userId);
        if (!ObjectUtils.allNotNull(user))
            throw new UserException(UserEnums.USER_NOT_EXISTS);
        return findAllProgramsByIds(user.getCollections());
    }

    /**
     * 模糊匹配
     * 匹配author,content,title,categoryName
     *
     * @param cond
     * @return
     */
    @Override
    public List<ProgramOutput> fuzzyQueryPrograms(String cond) {
        return ProgramConverter.converter(
                programDao.fuzzyQueryPrograms(cond, cond, cond, cond).
                        stream().filter(e -> e.getDeleted().equals(Boolean.FALSE))
                        .collect(Collectors.toList()));
    }

    /**
     * 查找所有用户编写的程序
     *
     * @param userId
     * @return
     */
    @Override
    public List<ProgramOutput> getProgramsByUserId(Integer userId) {
        User user = userDao.findById(userId);
        if (!ObjectUtils.allNotNull(user))
            throw new UserException(UserEnums.USER_NOT_EXISTS);
        return findAllProgramsByIds(user.getPrograms());
    }

    //判断程序和用户均存在
    private void notEmptyProgramAndUser(Program program, User user) {
        if (!ObjectUtils.allNotNull(program, user))
            throw new UserException(UserEnums.USER_NOT_EXISTS);
    }

    //判断程序是否已被删除
    private void validProgram(Program program) {
        if (Boolean.TRUE.equals(program.getDeleted())) {
            throw new ProgramException(ProgramEnums.PROGRAM_NOT_EXISTS);
        }

    }

    //判断target user 是否存储成功
    private void saveTargetUser(User user, String ids) {
        user = userDao.save(user);
        if (!ObjectUtils.allNotNull(user)) throw new UserException(UserEnums.USER_SAVE_ERROR);
    }

    private void saveTargetProgram(Program program) {
        program = programDao.save(program);
        if (!ObjectUtils.allNotNull(program)) throw new ProgramException(ProgramEnums.PROGRAM_SAVE_ERROR);
    }

    /**
     * 过滤被删除program
     *
     * @param ids
     * @return
     */
    private List<ProgramOutput> findAllProgramsByIds(String ids) {
        List<Integer> ids1 = StringUtils.string2List(
                ids).stream()
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());
        List<ProgramOutput> programs = ProgramConverter.converter(programDao.findAllByIdIn(ids1)
                .stream().filter(e -> e.getDeleted().equals(Boolean.FALSE))
                .collect(Collectors.toList()));
        return programs;
    }
}



package com.huidi.spring.boot.initializer.service.impl;

import com.huidi.spring.boot.initializer.convert.UserConverter;
import com.huidi.spring.boot.initializer.dao.UserDao;
import com.huidi.spring.boot.initializer.domain.User;
import com.huidi.spring.boot.initializer.enums.CommonEnums;
import com.huidi.spring.boot.initializer.enums.UserEnums;
import com.huidi.spring.boot.initializer.exception.CommonException;
import com.huidi.spring.boot.initializer.exception.UserException;
import com.huidi.spring.boot.initializer.from.LoginForm;
import com.huidi.spring.boot.initializer.from.RegisterForm;
import com.huidi.spring.boot.initializer.from.UserUpdateForm;
import com.huidi.spring.boot.initializer.service.UserService;
import com.huidi.spring.boot.initializer.utils.CommonOutputUtils;
import com.huidi.spring.boot.initializer.utils.StringUtils;
import com.huidi.spring.boot.initializer.vo.CommonOutput;
import com.huidi.spring.boot.initializer.vo.UserOutput;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final String REGISTER_SUCCESS = "注册成功";
    public static final String UPDATE_SUCCESS = "更新数据成功";
    public static final String LOGIN_SUCCESS = "登录成功";

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserOutput> getUsers() {
        return UserConverter.converter(userDao.findAll());
    }

    @Override
    public UserOutput getUser(Integer id) {
        return UserConverter.converter(userDao.findOne(id));
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public CommonOutput register(RegisterForm registerForm) {
        if (!registerForm.getConfirmPassword().equals(registerForm.getPassword())) {
            throw new UserException(UserEnums.PASSWORD_NOT_EQUAL);
        }
        //手机号和用户名需唯一
        if (ObjectUtils.allNotNull(userDao.findDistinctByMobilephone(registerForm.getMobilephone()) == null
                , userDao.findDistinctByUsername(registerForm.getUsername()))) {
            throw new UserException(UserEnums.USER_EXISTS);
        }
        User user = new User();
        BeanUtils.copyProperties(registerForm, user);
        user = userDao.save(user);
        return CommonOutputUtils.success(user.getId(), REGISTER_SUCCESS);
    }

    @Override
    public CommonOutput login(LoginForm loginForm) {
        User user = userDao.findDistinctByUsernameAndPassword(loginForm.getUsername(), loginForm.getPassword());
        if (user == null)
            throw new UserException(UserEnums.USER_NOT_EXISTS);
        return CommonOutputUtils.success(user.getId(), LOGIN_SUCCESS);
    }

    @Override
    public CommonOutput userUpdate(UserUpdateForm userUpdateForm) {
        Integer id = Integer.parseInt(userUpdateForm.getId());
        User user = userDao.findById(id);
        if (user == null)
            throw new UserException(UserEnums.USER_NOT_EXISTS);
        BeanUtils.copyProperties(userUpdateForm, user);
        user.setId(id);
        user = userDao.save(user);
        if (user == null)
            throw new UserException(UserEnums.USER_SAVE_ERROR);
        return CommonOutputUtils.success(user.getId(), user.getId() + " " + UPDATE_SUCCESS);
    }

    @Override
    public List<UserOutput> fuzzyQueryUsers(String cond) {
        return UserConverter.converter(
                userDao.fuzzyQueryUsers(cond, cond, cond));
    }

    /**
     * 查看用户关注列表
     *
     * @param uid
     * @return
     */
    @Override
    public List<UserOutput> getUsersByAttentions(Integer uid) {
        User user = userDao.findById(uid);
        if (!ObjectUtils.allNotNull(user))
            throw new UserException(UserEnums.USER_NOT_EXISTS);
        String ids = user.getAttentions();
        if (StringUtils.isEmpty(ids))
            throw new CommonException(CommonEnums.PARAM_INVALID);
        List<Integer> ids1 = StringUtils.string2List(ids)
                .stream().map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        List<User> users = userDao.findAllByIdIn(ids1);
        return UserConverter.converter(users);
    }

    /**
     * 取消关注该用户
     *
     * @param uid
     * @param id
     * @return
     */
    @Override
    public CommonOutput deleteAttentionFromUser(Integer uid, Integer id) {
        //用户不能关注自己
        if (uid.equals(id))
            throw new UserException(UserEnums.ATTENTION_YOURSELF);
        User user1 = userDao.findById(uid);
        User user2 = userDao.findById(id);
        notEmptyUser(user1, user2);
        String ids = StringUtils.deleteItem(user1.getAttentions(), String.valueOf(id));
        if (ids.equals(user1.getCollections()))
            throw new UserException(UserEnums.USER_ATTENTION_ERROR);
        saveTargetUser(user1, ids);
        return CommonOutputUtils.success(null, "取消关注用户成功");
    }

    /**
     * 关注用户
     *
     * @param uid
     * @param id
     * @return
     */
    @Override
    public CommonOutput appendAttentionFromUser(Integer uid, Integer id) {
        //用户不能关注自己
        if (uid.equals(id))
            throw new UserException(UserEnums.ATTENTION_YOURSELF);
        User user1 = userDao.findById(uid);
        User user2 = userDao.findById(id);
        notEmptyUser(user1, user2);
        String ids = StringUtils.appendItem(user1.getAttentions(), String.valueOf(id));
        if (ids.equals(user1.getCollections()))
            throw new UserException(UserEnums.USER_ATTENTION_ERROR);
        saveTargetUser(user1, ids);
        return CommonOutputUtils.success(null, "关注用户成功");
    }


    //判用户是否存在
    private void notEmptyUser(User first, User second) {
        if (!ObjectUtils.allNotNull(first, second))
            throw new UserException(UserEnums.USER_NOT_EXISTS);
    }


    //判断target user 是否存储成功
    private void saveTargetUser(User user, String ids) {
        user.setAttentions(ids);
        user = userDao.save(user);
        if (!ObjectUtils.allNotNull(user))
            throw new UserException(UserEnums.USER_SAVE_ERROR);
    }


}

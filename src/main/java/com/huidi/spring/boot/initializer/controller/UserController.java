package com.huidi.spring.boot.initializer.controller;


import com.huidi.spring.boot.initializer.enums.UserEnums;
import com.huidi.spring.boot.initializer.exception.UserException;
import com.huidi.spring.boot.initializer.from.LoginForm;
import com.huidi.spring.boot.initializer.from.RegisterForm;
import com.huidi.spring.boot.initializer.from.UserUpdateForm;
import com.huidi.spring.boot.initializer.service.CommentService;
import com.huidi.spring.boot.initializer.service.MessageService;
import com.huidi.spring.boot.initializer.service.ProgramService;
import com.huidi.spring.boot.initializer.service.UserService;
import com.huidi.spring.boot.initializer.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ProgramService programService;

    @GetMapping
    public List<UserOutput> listUsers() {
        return userService.getUsers();
    }


    //得到用户编写的程序
    @GetMapping("/{userid}/programs")
    public List<ProgramOutput> getUserPrograms(@PathVariable(name = "userid") Integer userid) {
        return programService.getProgramsByUserId(userid);
    }

    @GetMapping("/{userid}/delete/program/{programid}")
    public CommonOutput deleteProgramFromU(@PathVariable("programid") Integer programid, @PathVariable("userid") Integer userid) {
        return programService.deleteProgramFromUser(programid, userid);
    }

    @GetMapping("/{userid}/append/program/{programid}")
    public CommonOutput appendProgramFromU(@PathVariable("programid") Integer programid, @PathVariable("userid") Integer userid) {
        return programService.appendProgramForUser(programid, userid);
    }

    //得到用户收藏
    @GetMapping("/{userid}/collections")
    public List<ProgramOutput> getUserCollections(@PathVariable(name = "userid") Integer userid) {
        return programService.getCollectionsByUserId(userid);
    }

    @GetMapping("/{userid}/delete/collection/{programid}")
    public CommonOutput deleteCollectionFromU(@PathVariable("programid") Integer programid, @PathVariable("userid") Integer userid) {
        return programService.deleteCollectionFromUser(programid, userid);
    }

    @GetMapping("/{userid}/append/collection/{programid}")
    public CommonOutput appendCollectionFromU(@PathVariable("programid") Integer programid, @PathVariable("userid") Integer userid) {
        return programService.appendCollectionForUser(programid, userid);
    }


    @GetMapping("/{id}")
    public UserOutput getUser(@PathVariable(name = "id") Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/{id}/messages")
    public List<MessageOutput> getMessages(@PathVariable(name = "id") Integer id) {
        return messageService.getMessagesByUserId(id);
    }

    @GetMapping("/{id}/comments")
    public List<CommentOutput> getComments(@PathVariable(name = "id") Integer id) {
        return commentService.getCommentsByUserId(id);
    }

    @PostMapping("/register")
    public CommonOutput register(@Valid RegisterForm registerForm,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new UserException(UserEnums.REGISTER_FORM_ERROR);
        }
        return userService.register(registerForm);
    }

    @PostMapping("/login")
    public CommonOutput login(@Valid LoginForm loginForm,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new UserException(UserEnums.LOGIN_ERROR);
        }
        return userService.login(loginForm);
    }

    //用户关注取关接口 查询接口attentions
    @GetMapping("/{userid}/attentions/append/{uid}")
    public CommonOutput appendAttention(@PathVariable("userid") Integer userid,
                                        @PathVariable("uid") Integer uid) {
        return userService.appendAttentionFromUser(userid, uid);
    }

    @GetMapping("/{userid}/attentions/delete/{uid}")
    public CommonOutput deleteAttention(@PathVariable("userid") Integer userid,
                                        @PathVariable("uid") Integer uid) {
        return userService.deleteAttentionFromUser(userid, uid);
    }

    @GetMapping("/{userid}/attentions")
    public List<UserOutput> getAttentionUsers(@PathVariable("userid") Integer userid) {
        return userService.getUsersByAttentions(userid);
    }

    //用户模糊查询接口
    @GetMapping("/search/{cond}")
    public List<UserOutput> fuzzyQuery(@PathVariable("cond") String cond) {
        return userService.fuzzyQueryUsers(cond);
    }


    @PostMapping("/update")
    public CommonOutput updateUser(@Valid UserUpdateForm userUpdateForm,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new UserException(UserEnums.USER_UPDATE_FORM_ERROR);
        }
        return userService.userUpdate(userUpdateForm);
    }
}

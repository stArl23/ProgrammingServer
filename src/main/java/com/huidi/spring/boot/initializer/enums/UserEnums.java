package com.huidi.spring.boot.initializer.enums;

import lombok.Getter;

@Getter
public enum UserEnums {
    LOGIN_ERROR(1, "用户名或密码错误"),
    USER_EXISTS(2, "用户名已存在"),
    PASSWORD_NOT_EQUAL(3, "确认密码和密码不一致"),
    USER_SAVE_ERROR(4, "用户保存出错"),
    REGISTER_FORM_ERROR(5, "注册表单出错"),
    LOGIN_FORM_ERROR(6, "登录表单出错"),
    USER_NOT_EXISTS(7, "用户不存在"),
    PROGRAM_OR_USER_EMPTY(8, "用户或者程序为空"),
    USER_COLLECTION_ERROR(9, "添加或删除用户收藏失败"),
    USER_PROGRAM_ERROR(10, "用户添加或删除程序失败"),
    USER_COURSE_ERROR(11, "用户选中或者退选课程失败"),
    USER_OR_COURSE_EMPTY(12, "用户或者课程为空"),
    USER_ATTENTION_ERROR(13, "关注或取关用户失败"),
    ATTENTION_YOURSELF(14, "不能关注或取关自己"),
    USER_UPDATE_FORM_ERROR(15, "用户更新表单出错");


    private Integer id;
    private String message;

    UserEnums(Integer id, String message) {
        this.id = id;
        this.message = message;
    }
}

package com.thoughtworks.capacity.gtb.mvc.util;

public final class ErrorMessage {
    public static final String EMPTY_USERNAME = "用户名不为空";
    public static final String EMPTY_PASSWORD = "密码是不为空";
    public static final String INVALID_USERNAME = "用户名不合法";
    public static final String INVALID_PASSWORD = "密码不合法";
    public static final String INVALID_EMAIL = "邮箱地址不合法";
    public static final String USER_EXISTS = "用户已存在";
    public static final String USERNAME_AND_PASSWORD_NOT_MATCH = "用户名或密码错误";

    private ErrorMessage() {
    }
}

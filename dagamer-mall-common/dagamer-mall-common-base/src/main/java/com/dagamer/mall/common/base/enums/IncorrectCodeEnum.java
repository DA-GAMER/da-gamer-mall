package com.dagamer.mall.common.base.enums;

public enum IncorrectCodeEnum {

    UR1001(1001, "登录名不能为空"),

    UR1002(1002, "密码不能为空"),

    UR1003(1003, "两次密码不一致"),

    UR1004(1004, "登录名已存在"),

    UR1005(1005, "参数异常"),

    UR1006(1006, "用户不存在或账户密码错误");

    private int code;
    private String message;

    /**
     * Code.
     *
     * @return int
     */
    public int getCode() {
        return this.code;
    }

    /**
     * Message.
     *
     * @return String
     */
    public String getMessage() {
        return this.message;
    }

    IncorrectCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}

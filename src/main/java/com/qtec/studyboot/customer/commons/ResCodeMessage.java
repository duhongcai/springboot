package com.qtec.studyboot.customer.commons;

/**
 * Created by duhc on 2017/12/5.
 */
public enum  ResCodeMessage {
    RES_SUCCESS_MSG("0000","SUCCESS"),
    RES_FAIL_MSG("9999","fail"),

    //权限验证
    RES_UNKNOWN_ACCOUNT("9001","用户名或者密码错误"),
    RES_LOCKED_ACCOUNT("9002","账号已锁定"),
    RES_UNKNOWN_CAPTCHA("9003","验证码错误"),
    RES_UNAUTHENTICATED("9004","未登录用户"),
    RES_UNAUTHORIZATION("9401","无权访问当前资源"),

    ;


    private String resCode;
    private String resMessage;

    private ResCodeMessage(String resCode, String resMessage) {
        this.resCode = resCode;
        this.resMessage = resMessage;
    }

    public String getResCode() {
        return resCode;
    }

    public String getResMessage() {
        return resMessage;
    }
}

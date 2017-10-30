package com.qtec.studyboot.customer.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by duhc on 2017/10/30.
 */
public class Customer implements Serializable {
    /**
     * 会员Id
     */
    private Long id;
    //会员名
    private String cusName;
    //会员登录名
    private String loginName;
    //会员性别 1：男  2：女
    private int sex;
    //会员电话
    private String  telPhone;
    //会员注册地址
    private String address;
    //会员账户注册时间
    private Date regisDate;
    //会员信息更新时间
    private Date updateDate;
    //会员信息更新人
    private String updateName;

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegisDate() {
        return regisDate;
    }

    public void setRegisDate(Date regisDate) {
        this.regisDate = regisDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}

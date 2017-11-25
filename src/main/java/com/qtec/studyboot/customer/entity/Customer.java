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
    /**
     * 会员名
     */
    private String cusName;
    /**
     * 会员登录名
     */
    private String loginName;
    /**
     *  登录密码
     */
    private String password;
    /**
     * 会员性别 1：男  2：女
     */
    private int sex;
    /**
     * 会员电话
     */
    private String  telPhone;
    /**
     * 会员注册地址
     */
    private String address;
    /**
     * 会员账户注册时间
     */
    private Date regisDate;

    /**
     * 会员信息更新时间
     */
    private Date updateDate;

    /**
     *  会员信息更新人
     */
    private String updateName;

    /**
     * 会员等级
     *
     */
    private int level;
    /**
     * 账户类型
     */
    private int accountType;


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    /**
     * 校验唯一
     *  cusName  loginName  telPhone   accountType  address
     * @param
     * @return
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (accountType != customer.accountType) return false;
        if (cusName != null ? !cusName.equals(customer.cusName) : customer.cusName != null) return false;
        if (loginName != null ? !loginName.equals(customer.loginName) : customer.loginName != null) return false;
        if (telPhone != null ? !telPhone.equals(customer.telPhone) : customer.telPhone != null) return false;
        return address != null ? address.equals(customer.address) : customer.address == null;
    }

    @Override
    public int hashCode() {
        int result = cusName != null ? cusName.hashCode() : 0;
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (telPhone != null ? telPhone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + accountType;
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cusName='" + cusName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", sex=" + sex +
                ", telPhone='" + telPhone + '\'' +
                ", address='" + address + '\'' +
                ", regisDate=" + regisDate +
                ", updateDate=" + updateDate +
                ", updateName='" + updateName + '\'' +
                ", level=" + level +
                ", accountType=" + accountType +
                '}';
    }
}

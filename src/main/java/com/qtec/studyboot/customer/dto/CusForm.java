package com.qtec.studyboot.customer.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by duhc on 2017/11/16.
 */
public class CusForm implements Serializable {
    @NotNull
    @Size(min = 2, max = 30)
    private String loginName;

    @NotNull
    @Min(8)
    private String password;

    private String password2;


    @NotNull
    private String email;

    @NotNull
    private String telPhone;


    //    @NotNull
//    @Length(min = 4,max = 4)
    private String veriCode;

//    public String getPassword2() {
//        return password2;
//    }
//
//    public void setPassword2(String password2) {
//        this.password2 = password2;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVeriCode() {
        return veriCode;
    }

    public void setVeriCode(String veriCode) {
        this.veriCode = veriCode;
    }
}

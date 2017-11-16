package com.qtec.studyboot.customer.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by duhc on 2017/11/16.
 */
public class CusForm implements Serializable{
    @NotNull
    @Size(min = 2,max = 30)
    private String loginName;

    @NotNull
    @Min(8)
    private String password;

//    @NotNull
//    @Length(min = 4,max = 4)
    private String veriCode;

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

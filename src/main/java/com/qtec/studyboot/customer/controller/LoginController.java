package com.qtec.studyboot.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by duhc on 2017/11/22.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        int a = 1;
        //TODO 验证逻辑
       if (a == 1){

           return "customer/person";
       }else {
            return "customer/login";
       }
    }
}

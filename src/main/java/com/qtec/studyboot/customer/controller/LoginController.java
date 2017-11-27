package com.qtec.studyboot.customer.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by duhc on 2017/11/22.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login",method= RequestMethod.GET)
    public String login(){
        System.out.println("运行到这里1");
        return "customer/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model){
        System.out.println("运行到这里2");
        String name = request.getParameter("loginName");
        String password = request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        SecurityManager securityManager = SecurityUtils.getSecurityManager();
        Subject subject = SecurityUtils.getSubject();
       try{
           securityManager.login(subject,token);
           return "customer/person";
       }catch (AuthenticationException e){
           model.addAttribute("authentication",e.getLocalizedMessage());
           return "customer/login";
       }
    }
}

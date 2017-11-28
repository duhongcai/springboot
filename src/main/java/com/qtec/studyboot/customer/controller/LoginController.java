package com.qtec.studyboot.customer.controller;

import com.qtec.studyboot.customer.commons.CustomerUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
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
        return "customer/login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model){
        String name = request.getParameter("loginName");
        String password = request.getParameter("password");
        String captchaCode = request.getParameter("captchaCode");
        Session currentSession = CustomerUtils.getCurrentSession();
        String capCode = (String) currentSession.getAttribute("captcha");
       if (StringUtils.isEmpty(captchaCode)|| StringUtils.isEmpty(capCode)|| !capCode.equalsIgnoreCase(captchaCode)){
           model.addAttribute("errorMsg","验证码不正确");
           return "customer/login";
       }
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        Subject subject = SecurityUtils.getSubject();
       try{
           subject.login(token);
           return "customer/person";
       }catch (AuthenticationException e){
           model.addAttribute("errorMsg",e.getLocalizedMessage());
           return "customer/login";
       }
    }
}

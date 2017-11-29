package com.qtec.studyboot.customer.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by duhc on 2017/11/21.
 */
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView error(HttpServletRequest request, HttpServletResponse response,
                              Object handler, Exception ex) {
        System.out.println("全局异常信息捕获");
        ModelAndView mv = new ModelAndView("customer/404");
        mv.addObject("errorMessage", ex.getLocalizedMessage());
        return mv;
    }

    @ModelAttribute("contextPath")
    public String contextPath(HttpServletRequest request) {
        return request.getContextPath();
    }
}

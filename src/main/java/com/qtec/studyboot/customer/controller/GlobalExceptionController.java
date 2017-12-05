package com.qtec.studyboot.customer.controller;

import com.qtec.studyboot.customer.commons.CustomerUtils;
import com.qtec.studyboot.customer.commons.ResCodeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    static Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView error(HttpServletRequest request, HttpServletResponse response,
                              Object handler, Exception ex) {
        logger.error("全局异常信息捕获");
        if (CustomerUtils.checkAjaxReq(request)){
            CustomerUtils.sendJson(request,response, ResCodeMessage.RES_UNAUTHORIZATION);
            ModelAndView mv = new ModelAndView();
            return mv;
        }

        ModelAndView mv = new ModelAndView("customer/404");
        mv.addObject("errorMessage", ex.getLocalizedMessage());
        return mv;
    }

    @ModelAttribute("contextPath")
    public String contextPath(HttpServletRequest request) {
        return request.getContextPath();
    }
}

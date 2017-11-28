package com.qtec.studyboot.customer.controller;

import com.qtec.studyboot.customer.commons.CaptchaCodeUtils;
import com.qtec.studyboot.customer.commons.CustomerUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by duhc on 2017/11/28.
 */
@RestController
public class CommonController {

    /**
     * 获取验证码
     * 1：获取随机数
     * 2：获取当前session并将随机数保存到session  作为登录验证时校验
     * 3：将随机数以jpg图片形式输出到页面   作为页面校验
     * ImageIo.write(image,'jpg',response)
     * 注意问题：
     * 1）缓存：图片是静态资源 容易缓存
     * ·    2）识别度：不使用容易混淆的字符
     */
    @RequestMapping(value = "/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //设置浏览器不缓存图片
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpg");

        String captcha = CustomerUtils.generateCaptchaCode(4);
        Session session = CustomerUtils.getCurrentSession();
        session.setAttribute("captcha", captcha);
        int width = 160;
        int height = 40;
        CaptchaCodeUtils.outputImag(width, height, response.getOutputStream(), captcha);
    }

}

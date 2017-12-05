package com.qtec.studyboot.customer.commons;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Random;

/**
 * Created by duhc on 2017/10/30.
 *
 * 常用工具类
 */
public class CustomerUtils {
    static Logger logger = LoggerFactory.getLogger(CustomerUtils.class);
    private static String source="12345678wertyuasfhkzxcvbnmQWERTYUIPASFGHJKLZXVNM";
    /**
     * 获取随机数种子
     */
    public static String generateCaptchaCode(int length){
            StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int i1 = new Random().nextInt(source.length());
            sb.append(source.charAt(i1));
        }
        return sb.toString();
    }

    /**
     * 获取当前shiro的session
     * @return
     */
    public static Session getCurrentSession(){
        Session session = SecurityUtils.getSubject().getSession(true);
        return session;
    }

    /**
     * 判断当前请求是否为ajax请求
     * @param request
     */
    public static boolean checkAjaxReq(HttpServletRequest request){
        if ("XMLHttpRequest".equalsIgnoreCase(request.getHeader("x-requested-with"))){
            return true; //is ajax
        }
        return false;
    }

    /**
     *
     * @param request 请求request
     * @param response 响应response
     * @param codeMessage
     */
    public static void sendJson(HttpServletRequest request, HttpServletResponse response,ResCodeMessage codeMessage,String...excMessages){
        String resCode = codeMessage.getResCode();
        String message = codeMessage.getResMessage();
        if (excMessages != null){
            for (String excMessage : excMessages) {
                message += excMessage;
            }
        }
        Map<String,String> params = new HashedMap();
        params.put("resCode",resCode);
        params.put("resMessage",message);
        params.put("status","fail");
        //TODO 什么用
        SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
        if (savedRequest != null){
            params.put("reqUrl",savedRequest.getRequestUrl());
        }
        try{
            response.setContentType("text/plain;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println(JSON.toJSONString(params));
            writer.flush();
            writer.close();
        }catch (Exception e){
            logger.error("返回json失败："+e);
        }
    }

    public static void main(String[] args) {
        System.out.println(CustomerUtils.generateCaptchaCode(4));
    }
}

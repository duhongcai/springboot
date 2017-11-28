package com.qtec.studyboot.customer.commons;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import java.util.Random;

/**
 * Created by duhc on 2017/10/30.
 *
 * 常用工具类
 */
public class CustomerUtils {
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
    public static void main(String[] args) {
        System.out.println(CustomerUtils.generateCaptchaCode(4));
    }
}

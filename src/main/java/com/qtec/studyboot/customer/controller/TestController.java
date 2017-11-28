package com.qtec.studyboot.customer.controller;

import com.qtec.studyboot.customer.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by duhc on 2017/11/27.
 */
@Controller
@RequestMapping("/json")
public class TestController {

    /**
     * 测试json
     * @return
     */
    @ResponseBody
    @RequestMapping("/test")
    public Customer testJson(){
        Customer customer = new Customer();
        customer.setId(1l);
        customer.setLoginName("duhc");
        customer.setCusName("dududu");
        customer.setAddress("Zhejiang Hangzhou");
        customer.setRegisDate(new Date());
        return customer;
    }
}

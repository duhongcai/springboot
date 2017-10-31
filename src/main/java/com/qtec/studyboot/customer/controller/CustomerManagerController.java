package com.qtec.studyboot.customer.controller;

import com.qtec.studyboot.customer.entity.Customer;
import com.qtec.studyboot.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by duhc on 2017/10/30.
 */
@Controller
public class CustomerManagerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        System.out.println("获取列表");
        // 直接到resources资源文件下templates寻找响应文件
        //next 1： 热部署
        //next 2：日志
        //next 3：错误提示
        return "customer/list";
    }
}

package com.qtec.studyboot.customer.controller;

import com.qtec.studyboot.customer.dto.CusForm;
import com.qtec.studyboot.customer.entity.Customer;
import com.qtec.studyboot.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

/**
 * Created by duhc on 2017/10/30.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerManagerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerManagerController.class);
    @Autowired
    CustomerService customerService;

    @RequestMapping({"/","/index"})
    public String index() {
        logger.info("跳转到index页面");
        return "customer/index";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String login(CusForm cusForm) {
        return "customer/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid CusForm cusForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "customer/register";
        }
        Customer customer = new Customer();
        customer.setCusName(cusForm.getLoginName());
        customer.setRegisDate(new Date());
        customer.setAddress("Hangzhou Zhejiang");
        customer.setLoginName(cusForm.getLoginName());
        customer.setPassword(cusForm.getPassword());
        customer.setLevel(2);
        customer.setTelPhone(cusForm.getTelPhone());
        customer.setAccountType(0);
        customer.setSex(0);
        customerService.registCus(customer);
        model.addAttribute("customer", customer);
        return "customer/person";
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);
        logger.info("输出会员{}个", customers.size());
        // 直接到resources资源文件下templates寻找响应文件
        //next 1： 热部署
        //next 2：日志
        //next 3：错误提示
        return "customer/list";
    }

    @ResponseBody
    @RequestMapping(value = "/updateCus/{cusId}")
    public Customer updateCus(HttpServletRequest request, Customer customer,@PathVariable Long cusId) {
        logger.info("更新:"+cusId);
        return customer;
    }

    /**
     * 访问未授权页面
     * @return
     */
    @RequestMapping("/unAuthorization")
    public String unAuthorization(){
        return "customer/403";
    }
}

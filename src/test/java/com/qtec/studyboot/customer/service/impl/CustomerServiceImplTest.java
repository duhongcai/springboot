package com.qtec.studyboot.customer.service.impl;

import com.qtec.studyboot.customer.entity.Customer;
import com.qtec.studyboot.customer.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by duhc on 2017/11/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void addCus(){
        Customer customer = new Customer();
        customer.setLoginName("duhc");
        customer.setCusName("duhcr");
        customer.setLevel(2);
        customer.setRegisDate(new Date());
        customerService.registCus(customer);
    }

}
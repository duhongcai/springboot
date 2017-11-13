package com.qtec.studyboot.customer.service.impl;

import com.qtec.studyboot.customer.entity.Customer;
import com.qtec.studyboot.customer.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by duhc on 2017/11/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void addCus() {
        List<Customer> customers = new ArrayList<>();
        Customer customer;
        for (int i = 0; i < 10; i++) {
            customer =  new Customer();
            customer.setLoginName("duhc"+i);
            customer.setCusName("duhcr"+i);
            customer.setLevel(i);
            customer.setRegisDate(new Date());
            customers.add(customer);
        }
        int i = customerService.batchInsert(customers);
        System.out.println(i);
        System.out.println(customers);
    }

}
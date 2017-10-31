package com.qtec.studyboot.customer.service.impl;

import com.qtec.studyboot.customer.entity.Customer;
import com.qtec.studyboot.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duhc on 2017/10/30.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        Customer customer;
        //TODO DB
        for (int i = 0; i < 10; i++) {
            customer = new Customer();
            customer.setId(Long.valueOf(i+1));
            customer.setCusName("duhc-"+i);
            customer.setLoginName("ddd-"+i);
            customer.setAddress("浙江-杭州");
            customer.setLevel(1);
            customers.add(customer);
        }
        return customers;
    }
}

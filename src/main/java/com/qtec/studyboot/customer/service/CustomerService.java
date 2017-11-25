package com.qtec.studyboot.customer.service;

import com.qtec.studyboot.customer.entity.Customer;

import java.util.List;

/**
 * Created by duhc on 2017/10/30.
 */
public interface CustomerService {
    List<Customer> getCustomers();
    Customer getCustomerByName(String cusName);
    int registCus(Customer customer);
    int batchInsert(List<Customer> customers);
}

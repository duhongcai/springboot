package com.qtec.studyboot.customer.service.impl;

import com.qtec.studyboot.customer.dao.CustomerDao;
import com.qtec.studyboot.customer.entity.Customer;
import com.qtec.studyboot.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duhc on 2017/10/30.
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerDao customerDao;
    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = customerDao.getCustomer();
        return customers;
    }

    @Override
    public Customer getCustomerByName(String cusName) {
        Customer customer = new Customer();
        if (cusName != null){
             customer = customerDao.findByName(cusName);
        }
        return customer;
    }

    @Override
    public int registCus(Customer customer) {
        return customerDao.insert(customer);
    }

    @Override
    public int batchInsert(List<Customer> customers) {
        return customerDao.batchInsert(customers);
    }

    @Override
    public Customer getCustomerById(String cusId) {
        return customerDao.findById(cusId);
    }
}

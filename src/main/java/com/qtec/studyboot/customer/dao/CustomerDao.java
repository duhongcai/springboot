package com.qtec.studyboot.customer.dao;

import com.qtec.studyboot.customer.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by duhc on 2017/11/9.
 */

public interface CustomerDao extends BaseDao<Customer>{
    List<Customer> getCustomer();
}

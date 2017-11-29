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
        for (int i = 0; i < 5; i++) {
            customer =  new Customer();
            customer.setLoginName("duhc"+i);
            customer.setCusName("duhc");
            customer.setPassword("11032320");
            customer.setLevel(0);
            customer.setRegisDate(new Date());
            customers.add(customer);
        }
        int i = customerService.batchInsert(customers);
        System.out.println(i);
        System.out.println(customers);
    }

    @Test
    public void getCus(){
        Customer customer = customerService.getCustomerByName("duhc");
        System.out.println(customer.getPassword());
    }


    private static byte[] passCryp(byte[] passByte){
        int i=0;
        int j=0;
        //byte[] passByte =passStr.getBytes();
        char key[] = "g?ol0d!en@s7ec.1u8r$ityf*e#rr3*yw&a^y".toCharArray();
        char key1[] = "3g!#d34&fddf*d4adfd8)de+^dad*d57#daTga".toCharArray();
        char key2[] = "*dne71#dc&ia?yad>lad,ad3h*aducat3~da3)d".toCharArray();
        char key3[] = "-vdg9e*dqa1cF?Ka3,d3emca*^1p)u5i]ag2r*de".toCharArray();
        for (i =0;i<passByte.length;i++){
            if (i%2==0){
                if (i%5==0){
                    passByte[i]= (byte) (passByte[i]^key[j]);
                }
                else{
                    passByte[i]= (byte) (passByte[i]^key1[j]);
                }
            }else{
                if (i%3 ==0){
                    passByte[i]= (byte) (passByte[i]^key2[j]);
                }else{
                    passByte[i]= (byte) (passByte[i]^key3[j]);
                }
            }
            j++;
            if (j>36){
                j=0;
            }
        }
        return passByte;
    }

}
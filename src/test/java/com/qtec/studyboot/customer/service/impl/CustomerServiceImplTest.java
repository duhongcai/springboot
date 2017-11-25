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
        byte[] cus = new byte[16];
            cus[0] = 0x11;
            cus[1] = 0x22;
            cus[2] = 0x55;
            cus[3] =  0x66;
            cus[4] = 0x77;
            cus[5] = (byte) 0x88;
            cus[6] = (byte) 0x99;
            cus[7] = (byte) 0xaa;
            cus[8] = (byte) 0xbb;
            cus[9] = (byte) 0xcc;
            cus[10] =(byte) 0xdd;
            cus[11] = (byte) 0xee;
            cus[12] = (byte) 0xff;
            cus[13] = (byte) 0xfa;
            cus[14] =(byte) 0xfc;
            cus[15] = (byte) 0xfd;
        for (int i = 0; i < 5; i++) {
            customer =  new Customer();
            customer.setLoginName("duhc"+i);
            customer.setCusName("duhc");
            customer.setLevel(i);
            customer.setRegisDate(new Date());
            customers.add(customer);
        }
        int i = customerService.batchInsert(customers);
        System.out.println(i);
        System.out.println(customers);
    }

    @Test
    public void getCus(){
        List<Customer> customers = customerService.getCustomers();
       // for (Customer customer : customers) {
        byte[] cus = new byte[16];
        cus[0] = 0x11;
        cus[1] = 0x22;
        cus[2] = 0x55;
        cus[3] =  0x66;
        cus[4] = 0x77;
        cus[5] = (byte) 0x88;
        cus[6] = (byte) 0x99;
        cus[7] = (byte) 0xaa;
        cus[8] = (byte) 0xbb;
        cus[9] = (byte) 0xcc;
        cus[10] =(byte) 0xdd;
        cus[11] = (byte) 0xee;
        cus[12] = (byte) 0xff;
        cus[13] = (byte) 0xfa;
        cus[14] =(byte) 0xfc;
        cus[15] = (byte) 0xfd;
            int length = customers.get(22).getCusName().length();
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(cus[i]);
        }
        System.out.println();
    }

    public static byte[] passCryp(byte[] passByte){
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
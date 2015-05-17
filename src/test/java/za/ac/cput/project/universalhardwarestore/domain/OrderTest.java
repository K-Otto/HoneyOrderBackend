/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.universalhardwarestore.conf.factory.CustomerAccountFactory;
import za.ac.cput.project.universalhardwarestore.conf.factory.OrderFactory;

/**
 *
 * @author Garran
 */
public class OrderTest {
    
    @Test
    public void testCreate() throws Exception {
        
        Map<String,String> valuesCustomerAccount = new HashMap<String,String>();
        
        valuesCustomerAccount.put("customerID","43464373453");
        valuesCustomerAccount.put("phoneNumber", "2432525432");
        valuesCustomerAccount.put("email","garran@gmail.com");
        valuesCustomerAccount.put("accountNumber", "3957435734545");
        valuesCustomerAccount.put("status","ACTIVE");

        CustomerAccount customerAccount = CustomerAccountFactory
                .createCustomer(1000,valuesCustomerAccount,null,null);
        
        Map<String,String> values = new HashMap<String,String>();
        
        values.put("orderCode","2rf3t");
        values.put("shippedDate","13MAR2015");
        values.put("orderStatus","on route");
        values.put("description","On time");

        Order order = OrderFactory
                .createOrder(values,null, customerAccount);

        Assert.assertEquals("2rf3t",order.getOrderCode());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> valuesCustomerAccount = new HashMap<String,String>();
        
        valuesCustomerAccount.put("customerID","43464373453");
        valuesCustomerAccount.put("phoneNumber", "2432525432");
        valuesCustomerAccount.put("email","garran@gmail.com");
        valuesCustomerAccount.put("accountNumber", "3957435734545");
        valuesCustomerAccount.put("status","ACTIVE");

        CustomerAccount customerAccount = CustomerAccountFactory
                .createCustomer(1000,valuesCustomerAccount,null,null);
        
        Map<String,String> values = new HashMap<String,String>();
        
        values.put("orderCode","2rf3t");
        values.put("shippedDate","13MAR2015");
        values.put("orderStatus","on route");
        values.put("description","On time");

        Order order = OrderFactory
                .createOrder(values,null, customerAccount);

        Order copiedorder = OrderFactory
                .createOrder(values,null, customerAccount);
        
        Assert.assertEquals("2rf3t",order.getOrderCode());
        Assert.assertEquals("2rf3t",copiedorder.getOrderCode());
    }

}

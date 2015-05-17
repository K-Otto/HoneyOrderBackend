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
import za.ac.cput.project.universalhardwarestore.conf.factory.PaymentFactory;

/**
 *
 * @author Garran
 */
public class PaymentTest {
    
    @Test
    public void testCreate() throws Exception {
        Map<String,String> valuesCustomerAccount = new HashMap<String,String>();
        
        valuesCustomerAccount.put("customerID","43464373453");
        valuesCustomerAccount.put("phoneNumber", "2432525432");
        valuesCustomerAccount.put("email","garran@gmail.com");
        valuesCustomerAccount.put("accountNumber", "3957435734545");
        valuesCustomerAccount.put("status","ACTIVE");

        
        CustomerAccount customer = CustomerAccountFactory
                .createCustomer(1000,valuesCustomerAccount,null,null);
        
        Map<String,String> valuesOrder = new HashMap<String,String>();
        
        valuesOrder.put("orderCode","2rf3t");
        valuesOrder.put("shippedDate","13MAR2015");
        valuesOrder.put("orderStatus","on route");
        valuesOrder.put("description","On time");

        Order order = OrderFactory
                .createOrder(valuesOrder,null, null);
        
        Map<String,String> values = new HashMap<String,String>();
        
        values.put("paidDate","14MAR2015");

        Payment payment = PaymentFactory
                .createPayment(200.0, values, customer, order);

        Assert.assertEquals(200.0,payment.getTotal());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> valuesCustomerAccount = new HashMap<String,String>();
        
        valuesCustomerAccount.put("customerID","43464373453");
        valuesCustomerAccount.put("phoneNumber", "2432525432");
        valuesCustomerAccount.put("email","garran@gmail.com");
        valuesCustomerAccount.put("accountNumber", "3957435734545");
        valuesCustomerAccount.put("status","ACTIVE");

        
        CustomerAccount customer = CustomerAccountFactory
                .createCustomer(1000,valuesCustomerAccount,null,null);
        
        Map<String,String> valuesOrder = new HashMap<String,String>();
        
        valuesOrder.put("orderCode","2rf3t");
        valuesOrder.put("shippedDate","13MAR2015");
        valuesOrder.put("orderStatus","on route");
        valuesOrder.put("description","On time");

        Order order = OrderFactory
                .createOrder(valuesOrder,null, null);
        
        Map<String,String> values = new HashMap<String,String>();
        
        values.put("paidDate","14MAR2015");

        Payment payment = PaymentFactory
                .createPayment(200.0, values, customer, order);
        
        Payment copiedpayment = PaymentFactory
                .createPayment(220.0, values, customer, order);

        Assert.assertEquals(200.0,payment.getTotal());
        Assert.assertEquals(220.0,copiedpayment.getTotal());
    }
}

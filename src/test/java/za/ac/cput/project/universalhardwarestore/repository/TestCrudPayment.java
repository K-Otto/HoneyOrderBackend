///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package za.ac.cput.project.universalhardwarestore.repository;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import za.ac.cput.project.universalhardwarestore.conf.factory.CustomerAccountFactory;
//import za.ac.cput.project.universalhardwarestore.conf.factory.ItemsFactory;
//import za.ac.cput.project.universalhardwarestore.conf.factory.OrderFactory;
//import za.ac.cput.project.universalhardwarestore.conf.factory.PaymentFactory;
//import za.ac.cput.project.universalhardwarestore.domain.Address;
//import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;
//import za.ac.cput.project.universalhardwarestore.domain.Items;
//import za.ac.cput.project.universalhardwarestore.domain.Order;
//import za.ac.cput.project.universalhardwarestore.domain.Payment;
//
///**
// *
// * @author Garran
// */
//public class TestCrudPayment {
//    
//    private Long id;
//    private List<Items> items;
//    @Autowired
//    PaymentRepository repository;
//    
//    @BeforeMethod
//    public void setUp() throws Exception {
//         items = new ArrayList<Items>();
//    }
//    
//    @Test
//    public void create() throws Exception {
//        
//        Map<String,String> valuesItemsBots = new HashMap<String,String>();
//        
//        valuesItemsBots.put("itemNumber","23423");
//        
//        Items itemsBolts = ItemsFactory
//                .createItems(123, valuesItemsBots, null, null);
//        
//        Map<String,String> valuesItemsNails = new HashMap<String,String>();
//        
//        valuesItemsNails.put("itemNumber","35633");
//        
//        Items itemsNails = ItemsFactory
//                .createItems(123, valuesItemsNails, null, null);
//        
//        items.add(itemsNails);
//        items.add(itemsBolts);
//        
//        Address address = new Address.Builder("21 Vent Road")
//        .addressLine2("")
//        .suburb("Muizenberg")
//        .city("Cape Town")
//        .provence("Western Cape")
//        .postalCode("7945")
//        .build();
//        
//        Map<String,String> valuesCustomerAccount = new HashMap<String,String>();
//        
//        valuesCustomerAccount.put("customerID","43464373453");
//        valuesCustomerAccount.put("phoneNumber", "2432525432");
//        valuesCustomerAccount.put("email","garran@gmail.com");
//        valuesCustomerAccount.put("accountNumber", "3957435734545");
//        valuesCustomerAccount.put("status","ACTIVE");
//
//        
//        CustomerAccount customer = CustomerAccountFactory
//                .createCustomer(1000,valuesCustomerAccount,null,address);
//        
//        Map<String,String> valuesOrder = new HashMap<String,String>();
//        
//        valuesOrder.put("orderCode","2rf3t");
//        valuesOrder.put("shippedDate","13MAR2015");
//        valuesOrder.put("orderStatus","on route");
//        valuesOrder.put("description","On time");
//        valuesOrder.put("dateOrdered","11MAR2015");
//
//        Order order = OrderFactory
//                .createOrder(valuesOrder,items, null);
//
//        Payment payment = PaymentFactory
//                .createPayment(200.0, "14MAR2015", customer, order);
//        repository.save(payment);
//        id=payment.getId();
//        Assert.assertNotNull(payment.getId());
//    }
//
//    @Test(dependsOnMethods = "create")
//    public void read() throws Exception {
//        Payment payment = repository.findOne(id);
//        Assert.assertEquals("14MAR2015",payment.getPaidDate());
//    }
//
//    @Test(dependsOnMethods = "read")
//    public void update() throws Exception {
//
//        Payment payment = repository.findOne(id);
//        Payment newpayment = new Payment.Builder("14MAR2015").id(payment.getId())
//                .total(200.0).build();
//        repository.save(newpayment);
//        Assert.assertEquals("14MAR2015", payment.getPaidDate());
//        Assert.assertEquals("14MAR2015", newpayment.getPaidDate());
//    }
//
//    @Test(dependsOnMethods = "update")
//    public void delete() throws Exception {
//        Payment payment = repository.findOne(id);
//        repository.delete(payment);
//        Payment newpayment = repository.findOne(id);
//        Assert.assertNull(newpayment);
//    }
//}

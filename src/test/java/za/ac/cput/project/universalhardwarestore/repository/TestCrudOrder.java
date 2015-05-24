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
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import za.ac.cput.project.universalhardwarestore.App;
//import za.ac.cput.project.universalhardwarestore.conf.factory.CustomerAccountFactory;
//import za.ac.cput.project.universalhardwarestore.conf.factory.ItemsFactory;
//import za.ac.cput.project.universalhardwarestore.conf.factory.OrderFactory;
//import za.ac.cput.project.universalhardwarestore.conf.factory.UsersFactory;
//import za.ac.cput.project.universalhardwarestore.domain.Address;
//import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;
//import za.ac.cput.project.universalhardwarestore.domain.Items;
//import za.ac.cput.project.universalhardwarestore.domain.Order;
//import za.ac.cput.project.universalhardwarestore.domain.Users;
//
///**
// *
// * @author Garran
// */
//@SpringApplicationConfiguration(classes=App.class)
//@WebAppConfiguration
//public class TestCrudOrder extends AbstractTestNGSpringContextTests{
//    
//    private Long id;
//
//    private List<Items> items;
//    
//    @Autowired
//    OrderRepository repository;
//    
//    @BeforeMethod
//    public void setUp() throws Exception {
//         items = new ArrayList<Items>();
//    }
//    
//    @Test
//    public void create() throws Exception {
//        Users users = UsersFactory
//                .createUsers("garranm","1234","active");
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
//            .addressLine2("")
//            .suburb("Muizenberg")
//            .city("Cape Town")
//            .provence("Western Cape")
//            .postalCode("7945")
//            .build();
//        
//        Map<String,String> valuesCustomerAccount = new HashMap<String,String>();
//        
//        valuesCustomerAccount.put("customerID","43464373453");
//        valuesCustomerAccount.put("phoneNumber", "2432525432");
//        valuesCustomerAccount.put("email","garran@gmail.com");
//        valuesCustomerAccount.put("accountNumber", "3957435734545");
//        valuesCustomerAccount.put("status","ACTIVE");
//
//        CustomerAccount customerAccount = CustomerAccountFactory
//                .createCustomer(1000,valuesCustomerAccount,users,address);
//        
//        Map<String,String> values = new HashMap<String,String>();
//        
//        values.put("orderCode","2rf3t");
//        values.put("shippedDate","13MAR2015");
//        values.put("orderStatus","on route");
//        values.put("description","On time");
//         values.put("dateOrdered","12MAR2015");
//         
//        Order order = OrderFactory
//                .createOrder(values,items, customerAccount);
//        repository.save(order);
//        id=order.getId();
//        Assert.assertNotNull(order.getId());
//    }
//
//    @Test(dependsOnMethods = "create")
//    public void read() throws Exception {
//        Order order = repository.findOne(id);
//        Assert.assertEquals("2rf3t",order.getOrderCode());
//    }
//
//    @Test(dependsOnMethods = "read")
//    public void update() throws Exception {
//
//        Order order = repository.findOne(id);
//        Order neworder = new Order.Builder("2rf3t").id(order.getId())
//                .orderStatus("Delivered").build();
//        repository.save(neworder);
//        Assert.assertEquals("on route", order.getOrderStatus());
//        Assert.assertEquals("Delivered", neworder.getOrderStatus());
//    }
//
//    @Test(dependsOnMethods = "update")
//    public void delete() throws Exception {
//        Order order = repository.findOne(id);
//        repository.delete(order);
//        Order neworder = repository.findOne(id);
//        Assert.assertNull(neworder);
//    }
//}

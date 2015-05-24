///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package za.ac.cput.project.universalhardwarestore.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import za.ac.cput.project.universalhardwarestore.App;
//import za.ac.cput.project.universalhardwarestore.conf.factory.UsersFactory;
//import za.ac.cput.project.universalhardwarestore.domain.Users;
//import za.ac.cput.project.universalhardwarestore.repository.UsersRepository;
//
///**
// *
// * @author Garran
// */
//@SpringApplicationConfiguration(classes=App.class)
//@WebAppConfiguration
//public class UsersServiceTest extends AbstractTestNGSpringContextTests{
//    
//    private Long id;
//    
//    @Autowired
//    private UsersRepository repository; 
//    
//    @Test
//    public void create() throws Exception {
//        Users users = UsersFactory
//                .createUsers("garran","1234","active");
//
//        repository.save(users);
//        id=users.getId();
//        Assert.assertNotNull(users.getId());
//    }
//    
//    @Test
//    public void testGetUsers() throws Exception {
//        Users users = repository.findOne(id);
//        System.out.println(users.getId());
//        Assert.assertTrue(users.getId() == users.getId());
//    }
//    
//}

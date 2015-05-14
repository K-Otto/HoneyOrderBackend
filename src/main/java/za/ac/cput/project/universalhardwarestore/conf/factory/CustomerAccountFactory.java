///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package za.ac.cput.project.universalhardwarestore.conf.factory;
//
//import java.util.Map;
//import za.ac.cput.project.universalhardwarestore.domain.Address;
//import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;
//import za.ac.cput.project.universalhardwarestore.domain.Users;
//
///**
// *
// * @author Garran
// */
//public class CustomerAccountFactory {
//        public static CustomerAccount createCustomer(
//        Map<String,String> values,
//                Users users,
//                Address address){
//            CustomerAccount customer = new CustomerAccount
//            .Builder(values.get("086487678"))
//            .address(address)
//            .phoneNumber(values.get("0111675436"))
//            .email(values.get("garran@gmail.com"))
//            .accountNumber(values.get("53497334"))
//            .balance(1000)
//            .status(values.get("Active"))
//            .build();
//    return customer;
//    }
//}

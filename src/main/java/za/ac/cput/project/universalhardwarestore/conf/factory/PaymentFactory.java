///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package za.ac.cput.project.universalhardwarestore.conf.factory;
//
//import java.util.Map;
//import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;
//import za.ac.cput.project.universalhardwarestore.domain.Order;
//import za.ac.cput.project.universalhardwarestore.domain.Payment;
//
///**
// *
// * @author Garran
// */
//public class PaymentFactory {
//    public static Payment createPayment(
//                        Map<String,String> values,
//                        CustomerAccount customerAccount,
//                        Order order){
//        Payment payment = new Payment
//                .Builder(values.get("23-April-2015"))
//                .total(1200.00)
//                .customerAccount(customerAccount)
//                .order(order)
//                .build();
//        return payment;
//    }
//}

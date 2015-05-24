/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;
import za.ac.cput.project.universalhardwarestore.domain.Order;
import za.ac.cput.project.universalhardwarestore.domain.Payment;

/**
 *
 * @author Garran
 */
public class PaymentFactory {
    public static Payment createPayment(double total, String paidDate, CustomerAccount customerAccount, Order order){
        Payment payment = new Payment
                .Builder(paidDate)
                .total(total)
                .customerAccount(customerAccount)
                .order(order)
                .build();
        return payment;
    }
}

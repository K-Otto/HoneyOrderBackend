/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.List;
import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.Customer;

/**
 *
 * @author Garran
 */
public class CustomerFactory {
        public static Customer createCustomer(int customerID,
        Map<String,String> values,
        List<Customer> customer){
            Customer account = new Customer
            .Builder(values.get("086487678"))
            .customerID(customerID)
            .email(values.get("garran@gmail.com"))
            .build();
    return account;
    }
}

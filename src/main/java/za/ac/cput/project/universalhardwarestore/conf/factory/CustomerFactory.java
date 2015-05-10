/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.Account;
import za.ac.cput.project.universalhardwarestore.domain.Address;
import za.ac.cput.project.universalhardwarestore.domain.Customer;
import za.ac.cput.project.universalhardwarestore.domain.Users;

/**
 *
 * @author Garran
 */
public class CustomerFactory {
        public static Customer createCustomer(
        Map<String,String> values,
                Users users,
                Account account,
                Address address){
            Customer customer = new Customer
            .Builder(values.get("086487678"))
            .account(account)
            .address(address)
            .phoneNumber(values.get("0111675436"))
            .email(values.get("garran@gmail.com"))
            .build();
    return customer;
    }
}

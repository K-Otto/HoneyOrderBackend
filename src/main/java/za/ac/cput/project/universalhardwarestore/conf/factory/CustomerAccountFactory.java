/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.Address;
import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;
import za.ac.cput.project.universalhardwarestore.domain.Users;

/**
 *
 * @author Garran
 */
public class CustomerAccountFactory {
        public static CustomerAccount createCustomer(double balance,
        Map<String,String> values,
                Users users,
                Address address){
            CustomerAccount customer = new CustomerAccount
            .Builder(values.get("customerID"))
            .address(address)
            .phoneNumber(values.get("phoneNumber"))
            .email(values.get("email"))
            .accountNumber(values.get("accountNumber"))
            .balance(balance)
            .users(users)
            .status(values.get("status"))
            .build();
    return customer;
    }
}

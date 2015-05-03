/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.List;
import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.Account;
import za.ac.cput.project.universalhardwarestore.domain.Customer;

/**
 *
 * @author Garran
 */
public class AccountFactory {
    public static Account createAccount(double balance,
                        Map<String,String> values,
                        List<Customer> customer){
        Account account = new Account
                .Builder(values.get("Active"))
                .balance(balance)
                .customer(customer)
                .build();
        return account;
    }
}

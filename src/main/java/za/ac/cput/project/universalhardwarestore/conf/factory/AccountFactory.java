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
import za.ac.cput.project.universalhardwarestore.domain.Order;
import za.ac.cput.project.universalhardwarestore.domain.ShoppingCart;

/**
 *
 * @author Garran
 */
public class AccountFactory {
    public static Account createAccount(double balance,
                        Customer Customer,
                        Map<String,String> values,
                        List<ShoppingCart> shoppingCart,
                        List<Order> order){
        Account account = new Account
                .Builder(values.get("accountNumber"))
                .status(values.get("status"))
                .balance(balance)
                .customer(Customer)
                .accountNumber(values.get("accountNumber"))
                .build();
        return account;
    }
}

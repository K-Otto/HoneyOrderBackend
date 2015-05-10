/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.universalhardwarestore.conf.factory.AccountFactory;
import za.ac.cput.project.universalhardwarestore.conf.factory.CustomerFactory;


/**
 *
 * @author Garran
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @Test
    public void testCreateStock() throws Exception {
        Customer customer = new Customer();
        Map<String,String> values = new HashMap<String,String>();
        List<ShoppingCart> shoppingCart = new ArrayList<ShoppingCart>();
        List<Order> order = new ArrayList<Order>();
        values.put("accountNumber","245456567");
        values.put("status", "active");
        values.put("balance", "1000");
        
        Account account = AccountFactory.createAccount(25.00, customer, values, shoppingCart, order);
        
        Assert.assertEquals("245456567",account.getAccountNumber());
    }
    
    public void testUpadteCourse() throws Exception {
        Customer customer;
        Map<String,String> values = new HashMap<String,String>();
        List<ShoppingCart> shoppingCart = new ArrayList<ShoppingCart>();
        List<Order> order = new ArrayList<Order>();
        values.put("accountNumber","245456567");
        values.put("status", "active");
        values.put("balance", "1000");

        Account account = AccountFactory.createAccount(25.00, customer, values, shoppingCart, order);

        Account newaccount = new Account
                .Builder(account.getAccountNumber())
                .balance(account.getBalance())
                .status(account.getStatus())
                .copy(account)
                .build();

        Assert.assertEquals("245456567",newaccount.getAccountNumber());
        Assert.assertEquals("1000",newaccount.getBalance());
        Assert.assertEquals("active",newaccount.getStatus());
        Assert.assertEquals("active",account.getStatus());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.universalhardwarestore.conf.factory.CustomerAccountFactory;
import za.ac.cput.project.universalhardwarestore.conf.factory.ShoppingCartFactory;

/**
 *
 * @author Garran
 */
public class ShoppingCartTest {
    
    public ShoppingCartTest() {
    }

    @Test
    public void testCreate() throws Exception {
        
        //List<Items> items = new ArrayList<Items>();

        Map<String,String> valuesCust = new HashMap<String,String>();
        
        valuesCust.put("customerID","43464373453");
        valuesCust.put("phoneNumber", "2432525432");
        valuesCust.put("email","garran@gmail.com");
        valuesCust.put("accountNumber", "3957435734545");
        valuesCust.put("status","ACTIVE");
        
        CustomerAccount customer = CustomerAccountFactory
                .createCustomer(1000,valuesCust,null,null);
                
        Map<String,String> values = new HashMap<String,String>();
        
        values.put("dateCreated","13MAR2015");

        ShoppingCart shoppingCart = ShoppingCartFactory
                .createShoppingCart(values, customer, null);
        Assert.assertEquals("13MAR2015",shoppingCart.getDateCreated());
    }

    @Test
    public void testUpdate() throws Exception {
        //List<Items> items = new ArrayList<Items>();

        Map<String,String> valuesCust = new HashMap<String,String>();
        
        valuesCust.put("customerID","43464373453");
        valuesCust.put("phoneNumber", "2432525432");
        valuesCust.put("email","garran@gmail.com");
        valuesCust.put("accountNumber", "3957435734545");
        valuesCust.put("status","ACTIVE");
        
        CustomerAccount customer = CustomerAccountFactory
                .createCustomer(1000,valuesCust,null,null);
                
        Map<String,String> values = new HashMap<String,String>();
        
        values.put("dateCreated","13MAR2015");

        ShoppingCart shoppingCart = ShoppingCartFactory
                .createShoppingCart(values, customer, null);

        ShoppingCart copiedshoppingCart = new ShoppingCart
                .Builder("13MAR2015").copy(shoppingCart).customerAccount(customer).items(null).build();
        

        Assert.assertEquals("13MAR2015",shoppingCart.getDateCreated());
        Assert.assertEquals("13MAR2015",copiedshoppingCart.getDateCreated());
    }
}

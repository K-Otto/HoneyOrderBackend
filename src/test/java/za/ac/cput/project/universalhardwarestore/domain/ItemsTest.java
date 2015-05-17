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
import za.ac.cput.project.universalhardwarestore.conf.factory.ItemsFactory;
import za.ac.cput.project.universalhardwarestore.conf.factory.ShoppingCartFactory;

/**
 *
 * @author Garran
 */
public class ItemsTest {
    
    @Test
    public void testCreate() throws Exception {
        
        Map<String,String> valuesShoppingCart = new HashMap<String,String>();
        
        valuesShoppingCart.put("dateCreated","13MAR2015");

        ShoppingCart shoppingCart = ShoppingCartFactory
                .createShoppingCart(valuesShoppingCart, null, null);
        
        Stock stock = new Stock.Builder("N38653")
            .stockName("nails")
            .stockDescription("long")
            .quantity(1000)
            .price(20)
            .suppliers(null)
            .build();
        
        Map<String,String> values = new HashMap<String,String>();
        
        values.put("itemNumber","34234");
        
        Items items = ItemsFactory
                .createItems(78, values, shoppingCart, stock);

        Assert.assertEquals("34234",items.getItemNumber());
    }

    @Test
    public void testUpdate() throws Exception {
        Map<String,String> valuesShoppingCart = new HashMap<String,String>();
        
        valuesShoppingCart.put("dateCreated","13MAR2015");

        ShoppingCart shoppingCart = ShoppingCartFactory
                .createShoppingCart(valuesShoppingCart, null, null);
        
        Stock stock = new Stock.Builder("N38653")
            .stockName("nails")
            .stockDescription("long")
            .quantity(1000)
            .price(20)
            .suppliers(null)
            .build();
        
        Map<String,String> values = new HashMap<String,String>();
        
        values.put("itemNumber","34234");
        
        Items items = ItemsFactory
                .createItems(78, values, shoppingCart, stock);
        
        Items copieditems = ItemsFactory
                .createItems(70, values, shoppingCart, stock);

        Assert.assertEquals(78,items.getQuantity());
        Assert.assertEquals(70,copieditems.getQuantity());
    }
}

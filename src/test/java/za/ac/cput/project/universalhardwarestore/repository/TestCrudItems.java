/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.universalhardwarestore.App;
import za.ac.cput.project.universalhardwarestore.conf.factory.ItemsFactory;
import za.ac.cput.project.universalhardwarestore.conf.factory.ShoppingCartFactory;
import za.ac.cput.project.universalhardwarestore.domain.Items;
import za.ac.cput.project.universalhardwarestore.domain.ShoppingCart;
import za.ac.cput.project.universalhardwarestore.domain.Stock;
/**
 *
 * @author Garran
 */
@SpringApplicationConfiguration(classes=App.class)
@WebAppConfiguration
public class TestCrudItems extends AbstractTestNGSpringContextTests{
    
    private Long id;

    @Autowired
    ItemsRepository repository;
    @Test
    public void create() throws Exception {
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
        repository.save(items);
        id=items.getId();
        Assert.assertNotNull(items.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Items items = repository.findOne(id);
        Assert.assertEquals(78,items.getQuantity());
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {

        Items items = repository.findOne(id);
        Items newitems = new Items.Builder("34234").id(items.getId())
                .quantity(12).build();
        repository.save(newitems);
        Assert.assertEquals(78, items.getQuantity());
        Assert.assertEquals(12, newitems.getQuantity());
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Items items = repository.findOne(id);
        repository.delete(items);
        Items newitems = repository.findOne(id);
        Assert.assertNull(newitems);


    }
}

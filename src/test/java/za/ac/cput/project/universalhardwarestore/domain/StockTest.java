/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Garran
 */
public class StockTest{

    public StockTest(){
    }
    
    @Test
    public void create() throws Exception {
        Suppliers suppliers = new Suppliers.Builder("HardwareSupplier")
            .address(null)
            .supplierNumber("28743254368")
            .supplierEmail("hardwaresupplier@hardware.com")
            .build();
        
        Stock stock = new Stock.Builder("N38653")
            .stockName("nails")
            .stockDescription("long")
            .quantity(1000)
            .price(20)
            .suppliers(suppliers)
            .build();
              
        org.testng.Assert.assertEquals("nails",stock.getStockName());
    }

    @Test
    public void testUpdate() throws Exception {
        Suppliers suppliers = new Suppliers.Builder("HardwareSupplier")
            .address(null)
            .supplierNumber("28743254368")
            .supplierEmail("hardwaresupplier@hardware.com")
            .build();
        
        Stock stock = new Stock.Builder("N38653")
            .stockName("nails")
            .stockDescription("long")
            .quantity(1000)
            .price(20)
            .suppliers(suppliers)
            .build();

        Stock copiedstock = new Stock
                .Builder("N38653").copy(stock).stockName("nails").build();
        

        Assert.assertEquals("nails",stock.getStockName());
        Assert.assertEquals("nails",copiedstock.getStockName());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.Stock;

/**
 *
 * @author Garran
 */
public class TestCrudStock {
//    private Long id;
//    
//    @Autowired
//    StockRepository repository;
//    @Test
//    public void testCreate() throws Exception {
//        List<Stock> stocks = new ArrayList<Stock>();
//        Stock stock = new Stock.Builder("4545")
//                .stockName("Bolts").stockDescription("Silver").quantity(12).price(15).build();
//        repository.save(stock);
//        id=stock.getId();
//        Assert.assertNotNull(stock.getId());
//    }
//    
//    @Test
//    public void testRead() throws Exception {
//        Stock stock = repository.findOne(id);
//        Assert.assertEquals("Bolts",stock.getStockName());
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//
//        Stock stock = repository.findOne(id);
//        Stock newstock = new Stock.Builder("48").id(stock.getId())
//                .stockName("Hammer").stockDescription("black tip").quantity(12).price(15).build();
//        repository.save(newstock);
//        Assert.assertEquals("Hammer", stock.getStockName());
//        Assert.assertEquals("black tip", stock.getStockDescription());
//
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        Stock stock = repository.findOne(id);
//        repository.delete(stock);
//        Stock newstock = repository.findOne(id);
//        Assert.assertNull(newstock);
//    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.Stock;
import za.ac.cput.project.universalhardwarestore.services.Impl.StockServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Garran
 */

@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private StockServiceImpl service;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }
    
    //RequestMapping(value = "/stock",method = RequestMethod.GET)
    public Stock getStock(){
        Stock stock = new Stock.Builder("12345")
                .stockName("Drill").stockDescription("Power Drill").quantity(12).price(100.00).build();
        return stock;
    }
    
    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
    public List<Stock> getStocks(){
        return service.getStock();
    }
}

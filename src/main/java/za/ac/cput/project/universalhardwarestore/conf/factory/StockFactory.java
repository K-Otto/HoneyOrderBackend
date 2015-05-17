/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.List;
import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.Stock;
import za.ac.cput.project.universalhardwarestore.domain.Suppliers;

/**
 *
 * @author Garran
 */
public class StockFactory {
    
     public static Stock createStock(String stockCode, String stockName, String stockDescription, int quantity, double price, Suppliers suppliers){
         
         Stock stock = new Stock
                 .Builder(stockCode)
                 .stockName(stockName)
                 .stockDescription(stockDescription)
                 .quantity(quantity)
                 .price(price)
                 .suppliers(suppliers)
                 .build();
        return stock;
     }
}

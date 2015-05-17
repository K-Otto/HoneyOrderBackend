/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.services.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.universalhardwarestore.domain.Stock;
import za.ac.cput.project.universalhardwarestore.repository.StockRepository;
import za.ac.cput.project.universalhardwarestore.services.StockService;

/**
 *
 * @author Garran
 */
@Service
public class StockServiceImpl  implements StockService{
    @Autowired
    StockRepository repository;
    public List<Stock> getStock() {
        List<Stock> allStock = new ArrayList<Stock>();
         
        Iterable<Stock> stock = repository.findAll();
        for (Stock stocks : stock) {
            allStock.add(stocks);
        }
        return allStock;
    }
}


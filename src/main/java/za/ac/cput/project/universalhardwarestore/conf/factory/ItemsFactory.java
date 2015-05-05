/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.List;
import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.Items;
import za.ac.cput.project.universalhardwarestore.domain.ShoppingCart;
import za.ac.cput.project.universalhardwarestore.domain.Stock;

/**
 *
 * @author Garran
 */
public class ItemsFactory {
        public static Items createItems(int quantity,
                        Map<String,String> values,
                        List<Items> items){
        Items items = new Items
                .Builder(values.get("stockCode"))
                .stockName(values.get("stockName"))
                .stockDescription(values.get("stockDescription"))
                .quantity(Integer.parseInt(values.get("quantity")))
                .price(Double.parseDouble(values.get("price")))
                .suppliers(suppliers)
                .build();
        return items;
    }
}

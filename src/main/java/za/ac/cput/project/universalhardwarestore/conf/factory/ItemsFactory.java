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
        public static Items createItems(
                        Map<String,String> values,
                        List<ShoppingCart> shoppingCart,
                        Stock stock){
        Items items = new Items
                .Builder(values.get("1342"))
                .quantity(23)
                .stock(stock)
                .build();
        return items;
    }
}

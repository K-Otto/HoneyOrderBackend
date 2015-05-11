/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.List;
import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.ShoppingCart;

/**
 *
 * @author Garran
 */
public class ShoppingCartFactory {
            public static ShoppingCart createShoppingCart(int quantity,
                        Map<String,String> values,
                        List<Items> items){
        ShoppingCart shoppingCart = new ShoppingCart
                .Builder(values.get("stockCode"))
                .stockName(values.get("stockName"))
                .stockDescription(values.get("stockDescription"))
                .quantity(Integer.parseInt(values.get("quantity")))
                .price(Double.parseDouble(values.get("price")))
                .dateCreated(dateCreated)
                .build();
        return Items;
            }
}

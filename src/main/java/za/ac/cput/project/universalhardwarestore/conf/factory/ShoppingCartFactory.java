/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.List;
import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;
import za.ac.cput.project.universalhardwarestore.domain.Items;
import za.ac.cput.project.universalhardwarestore.domain.ShoppingCart;

/**
 *
 * @author Garran
 */
public class ShoppingCartFactory {
    public static ShoppingCart createShoppingCart(
                        Map<String,String> values,
                        CustomerAccount customerAccount,
                        List<Items> items){
        ShoppingCart shoppingCart = new ShoppingCart
                .Builder(values.get("dateCreated"))
                .customerAccount(customerAccount)
                .items(items)
                .build();
        return shoppingCart;
    }
}

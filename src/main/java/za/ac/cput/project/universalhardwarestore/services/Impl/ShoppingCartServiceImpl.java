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
import za.ac.cput.project.universalhardwarestore.domain.ShoppingCart;
import za.ac.cput.project.universalhardwarestore.repository.ShoppingCartRepository;
import za.ac.cput.project.universalhardwarestore.services.ShoppingCartService;

/**
 *
 * @author Garran
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{
    @Autowired
    ShoppingCartRepository repository;
    public List<ShoppingCart> getShoppingCart() {
        List<ShoppingCart> allShoppingCart = new ArrayList<ShoppingCart>();
         
        Iterable<ShoppingCart> shoppingCarts = repository.findAll();
        for (ShoppingCart shoppingCart : shoppingCarts) {
            allShoppingCart.add(shoppingCart);
        }
        return allShoppingCart;
    }
}

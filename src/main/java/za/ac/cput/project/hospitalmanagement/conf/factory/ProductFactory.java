/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.Category;
import za.ac.cput.project.hospitalmanagement.domain.Product;

/**
 *
 * @author Ancel
 */
public class ProductFactory {
    public static Product createProduct(String productName, String productDescription, double price, Category category) {
        Product product = new Product
                .Builder(productName)
                .productDescription(productDescription)
                .price(price)
                .categoryTitle(category)
                .build();
        return product;
    }
}

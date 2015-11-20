/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.services;
import java.util.List;
import za.ac.cput.project.hospitalmanagement.domain.Product;

/**
 *
 * @author Ancel
 */
public interface ProductServices {
    String saveProduct(String categoryTitle, String productName, String productDescription, double price);
    Product getProduct(Long id);
    void deleteProduct(Long id);
    Product getProductByProductName(String productName);
    List <Product> getAll();
    String updateProduct(String categoryTitle, String productName, String productDescription, double price, Long id);
}

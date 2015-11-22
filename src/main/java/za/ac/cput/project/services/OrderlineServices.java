/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.services;

import java.util.List;
import za.ac.cput.project.hospitalmanagement.domain.Orderline;

/**
 *
 * @author Ancel
 */
public interface OrderlineServices {
    String saveOrderline(String categoryTitle, String productName, String productDescription, double productPrice,
            String username, String password, String firstName, String lastName, String invoiceDate, double total,
            int quantity, double price);
    Orderline getOrderline(Long id);
    void deleteOrderline(Long id);
    List <Orderline> getAll();
    String updateOrderline(String categoryTitle, String productName, String productDescription, double productPrice,
            String username, String password, String firstName, String lastName, String invoiceDate, double total,
            int quantity, double price, Long id);
}

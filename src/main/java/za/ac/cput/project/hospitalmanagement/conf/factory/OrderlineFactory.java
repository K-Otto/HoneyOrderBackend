/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.Invoice;
import za.ac.cput.project.hospitalmanagement.domain.Orderline;
import za.ac.cput.project.hospitalmanagement.domain.Product;
import za.ac.cput.project.hospitalmanagement.domain.User;

/**
 *
 * @author Ancel
 */
public class OrderlineFactory {
    public static Orderline createOrderLine(int quantity, double price, User userId, Product productId, Invoice invoiceId) {
        Orderline orderline = new Orderline
                .Builder(quantity)
                .price(price)
                .userId(userId)
                .productId(productId)
                .invoiceId(invoiceId)
                .build();
        return orderline;
    }
}

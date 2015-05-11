/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import za.ac.cput.project.universalhardwarestore.domain.Order;
import za.ac.cput.project.universalhardwarestore.domain.OrderStatus;

/**
 *
 * @author Garran
 */
public class OrderFactory {
    public static Order createOrder(String orderCode,String dateOrdered,String shippedDate,String shipStatus,OrderStatus orderStatus){
        Order order = new Order
            .Builder(orderCode)
            .dateOrdered(dateOrdered)
            .shippedDate(shippedDate)
            .shipStatus(shipStatus)
            .orderStatus(orderStatus)
            .build();
        return order;
    }
}

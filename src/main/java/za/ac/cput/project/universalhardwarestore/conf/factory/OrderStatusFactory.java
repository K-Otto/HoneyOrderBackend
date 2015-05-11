/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import za.ac.cput.project.universalhardwarestore.domain.OrderStatus;

/**
 *
 * @author Garran
 */
public class OrderStatusFactory {
    public static OrderStatus createOrderStatus(String orderStatus,String description){
    
    OrderStatus orderStatus = new OrderStatus
                .Builder(orderStatus)
                .description(description)
                .build();
        return orderStatus;
    }
}

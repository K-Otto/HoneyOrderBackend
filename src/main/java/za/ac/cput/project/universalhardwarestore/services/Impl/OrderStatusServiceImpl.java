/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.services.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.OrderStatus;
import za.ac.cput.project.universalhardwarestore.repository.OrderStatusRepository;
import za.ac.cput.project.universalhardwarestore.services.OrderStatusService;

/**
 *
 * @author Garran
 */
public class OrderStatusServiceImpl implements OrderStatusService{
    @Autowired
    OrderStatusRepository repository;
    public List<OrderStatus> getOrdertus() {
        List<OrderStatus> allOrderStatus = new ArrayList<OrderStatus>();
         
        Iterable<OrderStatus> OrderStatus = repository.findAll();
        for (OrderStatus orderStatuss : OrderStatus) {
            allOrderStatus.add(orderStatuss);
        }
        return allOrderStatus;
    }
}

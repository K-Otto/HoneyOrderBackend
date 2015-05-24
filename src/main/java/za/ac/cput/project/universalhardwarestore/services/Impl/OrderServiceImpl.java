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
import za.ac.cput.project.universalhardwarestore.domain.Order;
import za.ac.cput.project.universalhardwarestore.repository.OrderRepository;
import za.ac.cput.project.universalhardwarestore.services.OrderService;

/**
 *
 * @author Garran
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository repository;
    public List<Order> getOrder() {
        List<Order> allOrder = new ArrayList<Order>();
        Iterable<Order> order = repository.findAll();
        for (Order orders : order) {
            allOrder.add(orders);
        }
        return allOrder;
    }
}

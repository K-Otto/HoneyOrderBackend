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
import za.ac.cput.project.universalhardwarestore.domain.Order;

/**
 *
 * @author Garran
 */
public class OrderFactory {
    public static Order createOrder(
                        Map<String,String> values,
                        List<Items> items,
                        CustomerAccount customerAccount){
        Order order = new Order
                .Builder(values.get("orderCode"))
                .dateOrdered(values.get("dateOrdered"))
                .shippedDate(values.get("shippedDate"))
                .orderStatus(values.get("orderStatus"))
                .description(values.get("description"))
                .customerAccount(customerAccount)
                .items(items)
                .build();
        return order;
    }
}

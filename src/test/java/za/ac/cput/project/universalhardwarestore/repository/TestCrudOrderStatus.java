/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.OrderStatus;

/**
 *
 * @author Garran
 */
public class TestCrudOrderStatus {
    
    private Long id;

    @Autowired
    OrderStatusRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<OrderStatus> OrderStatus = new ArrayList<OrderStatus>();
        OrderStatus orderStatus = new OrderStatus.Builder("311")
                .name("National Diploma IT").offering(2015).build();
        repository.save(orderStatus);
        id=orderStatus.getId();
        Assert.assertNotNull(orderStatus.getId());
    }

    @Test
    public void testRead() throws Exception {
        OrderStatus orderStatus = repository.findOne(id);
        Assert.assertEquals("National Diploma IT",orderStatus.getName());
    }

    @Test
    public void testUpdate() throws Exception {

        OrderStatus orderStatus = repository.findOne(id);
        OrderStatus neworderStatus = new OrderStatus.Builder("12").id(orderStatus.getId())
                .name("Diploma IT").offering(2014).build();
        repository.save(neworderStatus);
        Assert.assertEquals("Diploma IT", orderStatus.getName());
        Assert.assertEquals(2014, course.getOffering());

    }

    @Test
    public void testDelete() throws Exception {
        OrderStatus orderStatus = repository.findOne(id);
        repository.delete(orderStatus);
        OrderStatus neworderStatus = repository.findOne(id);
        Assert.assertNull(neworderStatus);


    }
}

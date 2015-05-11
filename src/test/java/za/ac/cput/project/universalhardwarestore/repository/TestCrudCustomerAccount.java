/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;

/**
 *
 * @author Garran
 */
public class TestCrudCustomerAccount {
    
//    private Long id;
//
//    @Autowired
//    CustomerRepository repository;
//    @Test
//    public void testCreate() throws Exception {
//        List<Customer> customer = new ArrayList<Customer>();
//        CustomerAccount customer = new CustomerAccount.Builder("311")
//                .name("National Diploma IT").offering(2015).build();
//        repository.save(customer);
//        id=customer.getId();
//        Assert.assertNotNull(customer.getId());
//    }
//
//    @Test
//    public void testRead() throws Exception {
//        CustomerAccount customer = repository.findOne(id);
//        Assert.assertEquals("National Diploma IT",customer.getName());
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//
//        CustomerAccount customer = repository.findOne(id);
//        CustomerAccount newcustomer = new CustomerAccount.Builder("12").id(customer.getId())
//                .name("Diploma IT").offering(2014).build();
//        repository.save(newcustomer);
//        Assert.assertEquals("Diploma IT", customer.getName());
//        Assert.assertEquals(2014, customer.getOffering());
//
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        CustomerAccount customer = repository.findOne(id);
//        repository.delete(customer);
//        CustomerAccount newcustomer = repository.findOne(id);
//        Assert.assertNull(newcustomer);
//
//
//    }
}

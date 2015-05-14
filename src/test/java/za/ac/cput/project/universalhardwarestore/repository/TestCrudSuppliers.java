///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package za.ac.cput.project.universalhardwarestore.repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.project.universalhardwarestore.domain.Suppliers;
//
///**
// *
// * @author Garran
// */
//public class TestCrudSuppliers {
////   private Long id;
////    @Autowired
////    SuppliersRepository repository;
////    
////    @Test
////    public void testCreate() throws Exception {
////        List<Suppliers> supplierss = new ArrayList<Suppliers>();
////        Suppliers suppliers = new Suppliers.Builder("311")
////                .name("National Diploma IT").offering(2015).build();
////        repository.save(suppliers);
////        id=suppliers.getId();
////        Assert.assertNotNull(suppliers.getId());
////    }
////
////    @Test
////    public void testRead() throws Exception {
////        Suppliers suppliers = repository.findOne(id);
////        Assert.assertEquals("National Diploma IT",suppliers.getName());
////    }
////
////    @Test
////    public void testUpdate() throws Exception {
////
////        Suppliers suppliers = repository.findOne(id);
////        Suppliers newsuppliers = new Suppliers.Builder("12").id(suppliers.getId())
////                .name("Diploma IT").offering(2014).build();
////        repository.save(newsuppliers);
////        Assert.assertEquals("Diploma IT", suppliers.getSupplierNumber());
////        Assert.assertEquals(2014, suppliers.getOffering());
////    }
////
////    @Test
////    public void testDelete() throws Exception {
////        Suppliers suppliers = repository.findOne(id);
////        repository.delete(suppliers);
////        Suppliers newsuppliers = repository.findOne(id);
////        Assert.assertNull(newsuppliers);
////    }
//}

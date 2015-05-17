/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;


import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.universalhardwarestore.conf.factory.AddressFactory;
import za.ac.cput.project.universalhardwarestore.conf.factory.SuppliersFactory;

/**
 *
 * @author Garran
 */
public class SuppliersTest {
    
    public SuppliersTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        
        Address address = AddressFactory
                .createAddress("21 Vent Road","","Muizenberg","Cape Town","Western Cape","7945");
        
        
        Suppliers suppliers = SuppliersFactory
                .createSupplier(address, "UniHardware", "2334675687", "UniHardware@gmail.com");
        Assert.assertEquals("UniHardware",suppliers.getSupplierName());
    }

    @Test
    public void testUpdate() throws Exception {
        Address address = AddressFactory
                .createAddress("21 Vent Road","","Muizenberg","Cape Town","Western Cape","7945");
        
        
        Suppliers suppliers = SuppliersFactory
                .createSupplier(address, "UniHardware", "2334675687", "UniHardware@gmail.com");

        Suppliers copiedsuppliers = SuppliersFactory
                .createSupplier(address, "UniHardware2", "2334675687", "UniHardware@gmail.com");
        
        Assert.assertEquals("UniHardware",suppliers.getSupplierName());
        Assert.assertEquals("UniHardware2",copiedsuppliers.getSupplierName());
    }
}

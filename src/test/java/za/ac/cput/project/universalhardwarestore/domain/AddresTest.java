/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;


import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.universalhardwarestore.conf.factory.AddressFactory;

/**
 *
 * @author Garran
 */
public class AddresTest {
    
        @Test
    public void testCreate() throws Exception {
        Address address = AddressFactory
                .createAddress("21 Vent Road","","Muizenberg","Cape Town","Western Cape","7945");
        Assert.assertEquals("21 Vent Road",address.getAddressLine1());
    }

    @Test
    public void testUpdate() throws Exception {
        Address address = AddressFactory
                .createAddress("21 Vent Road","","Muizenberg","Cape Town","Western Cape","7945");

        Address copiedaddress = new Address
                .Builder("21 Vent Road").copy(address).addressLine2("").suburb("Muizenberg").city("Cape Town").provence("Western Cape").postalCode("7945").build();
        Assert.assertEquals("Muizenberg",address.getSuburb());
        Assert.assertEquals("Muizenberg",copiedaddress.getSuburb());
        Assert.assertEquals("7945",address.getPostalCode());
        Assert.assertEquals("7945",copiedaddress.getPostalCode());

    }
}

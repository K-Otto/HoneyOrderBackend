/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.universalhardwarestore.conf.factory.AddressFactory;
import za.ac.cput.project.universalhardwarestore.conf.factory.CustomerAccountFactory;
import za.ac.cput.project.universalhardwarestore.conf.factory.UsersFactory;

/**
 *
 * @author Garran
 */
public class CustomerAccountTest {
    
    @Test
    public void testCreate() throws Exception {
        
        Address address = AddressFactory
                .createAddress("21 Vent Road","","Muizenberg","Cape Town","Western Cape","7945");
        
        Map<String,String> values = new HashMap<String,String>();
        
        values.put("customerID","43464373453");
        values.put("phoneNumber", "2432525432");
        values.put("email","garran@gmail.com");
        values.put("accountNumber", "3957435734545");
        values.put("status","ACTIVE");

        
        CustomerAccount customer = CustomerAccountFactory
                .createCustomer(1000,values,null,address);
        Assert.assertEquals("43464373453",customer.getCustomerID());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 *
 * @author Garran
 */
public class PaymentTest {
    
    @Test
    public void testCreate() throws Exception {
        Users users = UsersFactory
                .createUser("garran","1234","active");
        
        Address address = AddressFactory
                .createAddress("21 Vent Road","","Muizenberg","Cape Town","Western Cape","7945");
        
        Map<String,String> values = new HashMap<String,String>();
        CustomerAccount customer = CustomerAccountFactory
                .createCustomer(values,users,address);
        Assert.assertEquals("21 Vent Road",customer.getCustomerID());
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

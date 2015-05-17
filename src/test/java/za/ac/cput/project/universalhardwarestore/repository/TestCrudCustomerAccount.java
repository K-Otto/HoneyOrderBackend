/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.universalhardwarestore.App;
import za.ac.cput.project.universalhardwarestore.domain.Address;
import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;


/**
 *
 * @author Garran
 */
@SpringApplicationConfiguration(classes=App.class)
@WebAppConfiguration
public class TestCrudCustomerAccount extends AbstractTestNGSpringContextTests{
    
    private Long id;
    @Autowired
    CustomerAccountRepository repository;
    
    @Test
    public void create() throws Exception {
        //List<CustomerAccount> customerAccount = new ArrayList<CustomerAccount>();
        
        Address address = new Address.Builder("21 Vent Road")
            .addressLine2("")
            .suburb("Muizenberg")
            .city("Cape Town")
            .provence("Western Cape")
            .postalCode("7945")
            .build();
        
        CustomerAccount customerAccount = new CustomerAccount.Builder("086487678")
            .address(address)
            .phoneNumber("0111675436")
            .email("garran@gmail.com")
            .accountNumber("53497334")
            .balance(1000)
            .status("Active")
            .users(null)
            .build();
              
        repository.save(customerAccount);
        id=customerAccount.getId();
        Assert.assertNotNull(customerAccount.getId());
    }

    @org.testng.annotations.Test(dependsOnMethods = "create")
    public void read() throws Exception {
        CustomerAccount customerAccount = repository.findOne(id);
        Assert.assertEquals("086487678",customerAccount.getCustomerID());
    }

    @org.testng.annotations.Test(dependsOnMethods = "read")
    public void update() throws Exception {

        CustomerAccount customerAccount = repository.findOne(id);
        
        CustomerAccount newcustomerAccount = new CustomerAccount.Builder("086487678")
            .phoneNumber("0111675436")
            .email("garran@gmail.com")
            .balance(1080)
            .build();
        
        repository.save(newcustomerAccount);
        Assert.assertEquals("garran@gmail.com", customerAccount.getEmail());
        Assert.assertEquals("0111675436", customerAccount.getPhoneNumber());
    }

    @org.testng.annotations.Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        CustomerAccount customerAccount = repository.findOne(id);
        repository.delete(customerAccount);
        CustomerAccount newcustomerAccount = repository.findOne(id);
        Assert.assertNull(newcustomerAccount);
    }
}

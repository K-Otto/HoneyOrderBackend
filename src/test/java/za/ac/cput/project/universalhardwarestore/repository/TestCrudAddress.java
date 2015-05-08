/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.conf.factory.AddressFactory;
import za.ac.cput.project.universalhardwarestore.domain.Address;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Garran
 */
public class TestCrudAddress {
    
//    private Long id;
//
//    @Autowired
//    AddressRepository repository;
//    @Test
//    public void create() throws Exception {
//        
//        Address address = AddressFactory
//                .createAddress("21 Vent Road","","Muizenberg","Cape Town","Western Cape","7945");
//
//        repository.save(address);
//        id=address.getId();
//        Assert.assertNotNull(address.getId());
//    }
//
//    @Test(dependsOnMethods = "create")
//    public void read() throws Exception {
//        Address address = repository.findOne(id);
//        Assert.assertNotNull(address);
//
//
//    }
//
//    @Test(dependsOnMethods = "read")
//    public void update() throws Exception {
//        Address address = repository.findOne(id);
//
//        Address newaddress = new Address
//                .Builder(address.getAddressLine1())
//                //.copy(address)
//                .addressLine2(addressLine2)
//                .city(city)
//                .postalCode(postalCode)
//                .provence(provence)
//                .suburb(suburb)
//                .build();
//
//        repository.save(newaddress);
//
//        Address updatedAddress = repository.findOne(id);
//        Assert.assertEquals(updatedAddress.getAddressLine1(),"garran");
//
//    }
//
//    @Test(dependsOnMethods = "update")
//    public void delete() throws Exception {
//        Address address = repository.findOne(id);
//        repository.delete(address);
//        Address deletedAddress = repository.findOne(id);
//        Assert.assertNull(deletedAddress);
//
//    }
}

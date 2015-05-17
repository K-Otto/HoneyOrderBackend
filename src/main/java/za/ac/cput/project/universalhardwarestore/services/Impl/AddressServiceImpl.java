/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.services.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.Address;
import za.ac.cput.project.universalhardwarestore.repository.AddressRepository;
import za.ac.cput.project.universalhardwarestore.services.AddressService;

/**
 *
 * @author Garran
 */
public class AddressServiceImpl implements AddressService{
    @Autowired
    AddressRepository repository;
    public List<Address> getAddress() {
        List<Address> allAddress = new ArrayList<Address>();
        Iterable<Address> address = repository.findAll();
        for (Address addresss : address) {
            allAddress.add(addresss);
        }
        return allAddress;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.services.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.Customer;
import za.ac.cput.project.universalhardwarestore.repository.CustomerRepository;
import za.ac.cput.project.universalhardwarestore.services.CustomerService;

/**
 *
 * @author Garran
 */
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository repository;
    public List<Customer> getCustomer() {
        List<Customer> allCustomer = new ArrayList<Customer>();
        Iterable<Customer> customer = repository.findAll();
        for (Customer customers : customer) {
            allCustomer.add(customers);
        }
        return allCustomer;
    }
}

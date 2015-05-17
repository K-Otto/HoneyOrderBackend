/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.services.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;
import za.ac.cput.project.universalhardwarestore.repository.CustomerAccountRepository;
import za.ac.cput.project.universalhardwarestore.services.CustomerAccountService;

/**
 *
 * @author Garran
 */
public class CustomerAccountServiceImpl implements CustomerAccountService{
    @Autowired
    CustomerAccountRepository repository;
    public List<CustomerAccount> getCustomerAccount() {
                List<CustomerAccount> allCustomer = new ArrayList<CustomerAccount>();
        Iterable<CustomerAccount> customerAccount = repository.findAll();
        for (CustomerAccount customersAccounts : customerAccount) {
            allCustomer.add(customersAccounts);
        }
        return allCustomer;
    }
}

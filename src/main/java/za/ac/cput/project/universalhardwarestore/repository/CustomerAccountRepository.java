/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.universalhardwarestore.domain.CustomerAccount;

/**
 *
 * @author Garran
 */
public interface CustomerAccountRepository  extends CrudRepository<CustomerAccount,Long>{
    public CustomerAccount findByCustomerID(String customerID);
}
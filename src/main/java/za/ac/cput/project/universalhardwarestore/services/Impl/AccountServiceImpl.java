/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.services.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.Account;
import za.ac.cput.project.universalhardwarestore.repository.AccountRepository;
import za.ac.cput.project.universalhardwarestore.services.AccountService;

/**
 *
 * @author Garran
 */
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountRepository repository;

    public List<Account> getAccount() {
        List<Account> allAccount = new ArrayList<Account>();
        Iterable<Account> account = repository.findAll();
        for (Account accounts : account) {
            allAccount.add(accounts);
        }
        return allAccount;
    }
}

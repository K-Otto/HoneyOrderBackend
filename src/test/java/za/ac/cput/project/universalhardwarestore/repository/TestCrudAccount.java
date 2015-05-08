/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.Account;

/**
 *
 * @author Garran
 */
public class TestCrudAccount {
    
//    private Long id;
//
//    @Autowired
//    AccountRepository repository;
//    @Test
//    public void testCreate() throws Exception {
//        List<Account> accounts = new ArrayList<Account>();
//        Account account = new Account.Builder("311")
//                .balance(12.00)
//                .status("Active")
//                .customer()
//                .build();
//        repository.save(account);
//        id=account.getId;
//        Assert.assertNotNull(account.getId());
//    }
//
//    @Test
//    public void testRead() throws Exception {
//        Account account = repository.findOne(id);
//        Assert.assertEquals("National Diploma IT",account.getName());
//    }
//
//    @Test
//    public void testUpdate() throws Exception {
//
//        Account account = repository.findOne(id);
//        Account newaccount = new Account.Builder("12").id(account.getId())
//                .name("Diploma IT").offering(2014).build();
//        repository.save(newaccount);
//        Assert.assertEquals("Diploma IT", account.getName());
//        Assert.assertEquals(2014, account.getOffering());
//
//    }
//
//    @Test
//    public void testDelete() throws Exception {
//        Account account = repository.findOne(id);
//        repository.delete(account);
//        Account newaccount = repository.findOne(id);
//        Assert.assertNull(newaccount);
//
//
//    }
}

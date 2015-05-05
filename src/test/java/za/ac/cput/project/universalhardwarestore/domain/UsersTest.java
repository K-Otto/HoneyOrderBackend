/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import za.ac.cput.project.universalhardwarestore.conf.factory.UserFactory;

/**
 *
 * @author Garran
 */
public class UsersTest {
    
    public UsersTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        User users = UserFactory
                .createUser("garran","1234","active");
        Assert.assertEquals("garran",users.getUserName());
    }

    @Test
    public void testUpdate() throws Exception {
        User users = UserFactory
                .createUser("garran","1234","active");

        User copiedUser = new User
                .Builder("test@test.comm").copy(address).postalCode("700").build();
        Assert.assertEquals("test@test.com",address.getEmail());
        Assert.assertEquals("test@test.com",copiedaddress.getEmail());
        Assert.assertEquals("7557",address.getPostalCode());
        Assert.assertEquals("700",copiedaddress.getPostalCode());

    }
}

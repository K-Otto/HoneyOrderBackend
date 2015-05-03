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
import za.ac.cput.project.universalhardwarestore.domain.User;

/**
 *
 * @author Garran
 */
public class TestCrudUsers {
    private Long id;

    @Autowired
    UserRepository repository;
    @Test
    public void testCreate() throws Exception {
        List<User> users = new ArrayList<User>();
        User user = new User.Builder("311")
                .name("National Diploma IT").offering(2015).build();
        repository.save(user);
        id=user.getId();
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void testRead() throws Exception {
        User course = repository.findOne(id);
        Assert.assertEquals("National Diploma IT",course.getName());
    }

    @Test
    public void testUpdate() throws Exception {

        User user = repository.findOne(id);
        User newcourse = new User.Builder("12").id(user.getId())
                .name("Diploma IT").offering(2014).build();
        repository.save(newcourse);
        Assert.assertEquals("Diploma IT", user.getName());
        Assert.assertEquals(2014, user.getOffering());

    }

    @Test
    public void testDelete() throws Exception {
        User user = repository.findOne(id);
        repository.delete(user);
        User newuser = repository.findOne(id);
        Assert.assertNull(newuser);


    }
}

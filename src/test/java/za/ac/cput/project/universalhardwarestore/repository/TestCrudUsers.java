/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

//import org.junit.Assert;
//import org.junit.Test;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.project.universalhardwarestore.conf.factory.UsersFactory;
import za.ac.cput.project.universalhardwarestore.domain.Users;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.universalhardwarestore.App;

/**
 *
 * @author Garran
 */
@SpringApplicationConfiguration(classes=App.class)
@WebAppConfiguration
public class TestCrudUsers extends AbstractTestNGSpringContextTests{
    private Long id;

    @Autowired
    UsersRepository repository;    
    @Test
    public void create() throws Exception {
        Users user = UsersFactory
                .createUser("garran","1234","active");

        repository.save(user);
        id=user.getId();
        Assert.assertNotNull(user.getId());
    }
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Users user = repository.findOne(id);
        Assert.assertNotNull(user);


    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Users user = repository.findOne(id);

        Users newuser = new Users
                .Builder(user.getUserName())
                .copy(user)
                //.password(password)
                //.status(status)
                .build();

        repository.save(newuser);

        Users updatedUser = repository.findOne(id);
        Assert.assertEquals(updatedUser.getUserName(),"garran");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Users user = repository.findOne(id);
        repository.delete(user);
        Users deletedUser = repository.findOne(id);
        Assert.assertNull(deletedUser);
    }
}

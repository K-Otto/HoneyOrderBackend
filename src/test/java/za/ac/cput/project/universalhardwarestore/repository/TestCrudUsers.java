/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

//import org.junit.Assert;
//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.conf.factory.UserFactory;
import za.ac.cput.project.universalhardwarestore.domain.User;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Garran
 */
public class TestCrudUsers {
        private Long id;

    @Autowired
    private UserRepository repository;

    @Test
    public void create() throws Exception {
        
        User user = UserFactory
                .createUser("garran","1234","active");

        repository.save(user);
        id=user.getId();
        Assert.assertNotNull(user.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        User user = repository.findOne(id);
        Assert.assertNotNull(user);


    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        User user = repository.findOne(id);

        User newuser = new User
                .Builder(user.getUserName())
                .copy(user)
                //.password(password)
                //.status(status)
                .build();

        repository.save(newuser);

        User updatedUser = repository.findOne(id);
        Assert.assertEquals(updatedUser.getUserName(),"garran");

    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        User user = repository.findOne(id);
        repository.delete(user);
        User deletedUser = repository.findOne(id);
        Assert.assertNull(deletedUser);

    }
}

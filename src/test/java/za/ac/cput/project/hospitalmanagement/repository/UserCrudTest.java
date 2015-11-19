/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.App;
import za.ac.cput.project.hospitalmanagement.conf.factory.UserFactory;
import za.ac.cput.project.hospitalmanagement.domain.User;
import za.ac.cput.project.hospitalmanagement.repository.UserRepository;
/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class UserCrudTest extends AbstractTestNGSpringContextTests {
    private long id;
    @Autowired
    private UserRepository repository;
    
    @Test
    public void create() throws Exception {  
        User user = UserFactory
                .createUser("John123", "p@ssword", "John", "Doe");
        repository.save(user);
        id=user.getUserId();
        Assert.assertNotNull(user.getUserId());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        User user = repository.findOne(id);
        Assert.assertEquals("John123", user.getUsername());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        User user = repository.findOne(id);
        User newUser = new User.Builder("User123").copy(user).build();
        repository.save(newUser);
        User updatedUser = repository.findOne(id);
        Assert.assertEquals("John123", user.getUsername());
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        User user = repository.findOne(id);
        repository.delete(user);        
        User deletedUser = repository.findOne(id);
        Assert.assertNull(deletedUser);
    }
}

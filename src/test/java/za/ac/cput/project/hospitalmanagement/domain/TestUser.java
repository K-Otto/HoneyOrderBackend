/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;
import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.*;
import za.ac.cput.project.hospitalmanagement.conf.factory.UserFactory;
import za.ac.cput.project.hospitalmanagement.domain.User;
/**
 *
 * @author Ancel
 */
public class TestUser {
    @Test
    public void testCreate() throws Exception{
        User user = UserFactory
                .createUser("John123", "p@ssword", "John", "Doe");
        Assert.assertEquals("John123", user.getUsername());
    }
    
    @Test
    public void testUpdate() throws Exception {
        User user = UserFactory
                .createUser("John123", "p@ssword", "John", "Doe");
        User copiedUser = new User.Builder("User123").copy(user).build();
        Assert.assertEquals("John123", user.getUsername());
        Assert.assertEquals("John123", copiedUser.getUsername());
    }
}

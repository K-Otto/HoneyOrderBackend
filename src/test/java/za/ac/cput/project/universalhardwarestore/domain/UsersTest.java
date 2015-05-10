/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;


//import org.junit.Assert;
//import org.junit.Test;
import za.ac.cput.project.universalhardwarestore.conf.factory.UsersFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 *
 * @author Garran
 */
public class UsersTest {
    
    public UsersTest() {
    }
    
    @Test
    public void testCreate() throws Exception {
        Users users = UsersFactory
                .createUser("garran","1234","active");
        Assert.assertEquals("garran",users.getUserName());
    }

    @Test
    public void testUpdate() throws Exception {
        Users users = UsersFactory
                .createUser("garran","1234","active");

        Users copiedUser = new Users
                .Builder("garran").copy(users).password("1234").status("active").build();
        Assert.assertEquals("garran",users.getUserName());
        Assert.assertEquals("garran",copiedUser.getUserName());
        Assert.assertEquals("1234",users.getPassword());
        Assert.assertEquals("1234",copiedUser.getPassword());

    }
}

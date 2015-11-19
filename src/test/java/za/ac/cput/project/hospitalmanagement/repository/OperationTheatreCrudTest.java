/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.App;
import za.ac.cput.project.hospitalmanagement.conf.factory.OperationTheatreFactory;
import za.ac.cput.project.hospitalmanagement.domain.OperationTheatre;
/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class OperationTheatreCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private OperationTheatreRepository repository;
    
    @Test
    public void create() throws Exception {             
        OperationTheatre operationTheatre = OperationTheatreFactory
                .createOperationTheatre("Small");
        repository.save(operationTheatre);
        id = operationTheatre.getTheatreNo();
        Assert.assertNotNull(operationTheatre.getTheatreNo());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        OperationTheatre operationTheatre = repository.findOne(id);
        Assert.assertEquals("Small", operationTheatre.getOperationRoomSize());
    }
    
      @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        OperationTheatre operationTheatre = repository.findOne(id);
        OperationTheatre newOperationTheatre = new OperationTheatre
                .Builder("Large")
                .copy(operationTheatre)
                .build();
        repository.save(newOperationTheatre);
        OperationTheatre updatedOperationTheatre = repository.findOne(id);
        Assert.assertEquals(updatedOperationTheatre.getOperationRoomSize(), "Small");
    }
      
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        OperationTheatre operationTheatre = repository.findOne(id);
        repository.delete(operationTheatre);
        OperationTheatre deletedOperationTheatre = repository.findOne(id);
        Assert.assertNull(deletedOperationTheatre);
    }  
}

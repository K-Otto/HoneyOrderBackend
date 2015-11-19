/*
 * To change this template, choose Tools | Templates
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
import za.ac.cput.project.hospitalmanagement.conf.factory.OperationFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.OperationTheatreFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
import za.ac.cput.project.hospitalmanagement.domain.Operation;
import za.ac.cput.project.hospitalmanagement.domain.OperationTheatre;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class OperationCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private OperationRepository repository;
    
    @Test
    public void create() throws Exception {  
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        OperationTheatre operationTheatre = OperationTheatreFactory
                .createOperationTheatre("Small");
        Operation operation = OperationFactory
                .createOperation("12:00", operationTheatre, treatment);
        repository.save(operation);
        id=operation.getOperationID();
        Assert.assertNotNull(operation.getOperationID());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Operation operation = repository.findOne(id);
        Assert.assertEquals("12:00", operation.getStartTime());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Operation operation = repository.findOne(id);
        Operation newOperation = new Operation
                .Builder("09:00")
                .copy(operation)
                .build();
        repository.save(newOperation);
        Operation updatedOperation = repository.findOne(id);
        Assert.assertEquals(updatedOperation.getStartTime(), "12:00");
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Operation operation = repository.findOne(id);
        repository.delete(operation); 
        Operation deletedOperation = repository.findOne(id);
        Assert.assertNull(deletedOperation);
    }
}

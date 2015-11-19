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
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class TreatmentCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private TreatmentRepository repository;
    
    
    @Test
    public void create() throws Exception {  
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        repository.save(treatment);
        id=treatment.getTreatmentID();
        Assert.assertNotNull(treatment.getTreatmentID());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Treatment treatment = repository.findOne(id);
        Assert.assertEquals("22/07/2015", treatment.getDateAdmitted());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Treatment treatment = repository.findOne(id);
        Treatment newTreatment = new Treatment
                .Builder("29/07/2015")
                .copy(treatment)
                .build();
        repository.save(newTreatment);
        Treatment updatedTreatment = repository.findOne(id);
        Assert.assertEquals("22/07/2015", updatedTreatment.getDateAdmitted());
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Treatment treatment = repository.findOne(id);
        repository.delete(treatment);        
        Treatment deletedTreatment = repository.findOne(id);
        Assert.assertNull(deletedTreatment);
    }
}

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
import za.ac.cput.project.hospitalmanagement.conf.factory.MedicineFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
import za.ac.cput.project.hospitalmanagement.domain.Medicine;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class MedicineCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private MedicineRepository repository;
    
    
    @Test
    public void create() throws Exception {  
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Long treatmentID = treatment.getTreatmentID();
        Medicine medicine = MedicineFactory
                .createMedicine("Amoxicillin", "Antibiotic", 100, treatmentID);
        repository.save(medicine);
        id = medicine.getMedicineID();
        Assert.assertNotNull(medicine.getMedicineID());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Medicine medicine = repository.findOne(id);
        Assert.assertEquals("Amoxicillin", medicine.getMedicineName());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Medicine medicine = repository.findOne(id);
        Medicine newMedicine = new Medicine
                .Builder("Ampicillin")
                .copy(medicine)
                .build();
        repository.save(newMedicine);
        Medicine updatedMedicine = repository.findOne(id);
        Assert.assertEquals(updatedMedicine.getMedicineName(), "Amoxicillin");
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Medicine medicine = repository.findOne(id);
        repository.delete(medicine);
        Medicine deletedMedicine = repository.findOne(id);
        Assert.assertNull(deletedMedicine);
    }
}

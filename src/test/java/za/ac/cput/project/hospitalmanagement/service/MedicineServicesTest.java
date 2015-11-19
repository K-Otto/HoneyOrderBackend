/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.App;
import za.ac.cput.project.hospitalmanagement.conf.factory.MedicineFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
import za.ac.cput.project.hospitalmanagement.domain.Medicine;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
import za.ac.cput.project.services.MedicineServices;
/**
 *
 * @author Ancel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class MedicineServicesTest extends AbstractTestNGSpringContextTests{
    private Long id;
     private Medicine medicineGlobal;
    
    @Autowired
    private MedicineServices service;
    
     @Test
    public void create() throws Exception {
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Long treatmentID = treatment.getTreatmentID();
        Medicine medicine = MedicineFactory
                .createMedicine("Amoxicillin", "Antibiotic", 100, treatmentID);
        
        Long treatmentId = Long.parseLong(1 + "");
        
        service.saveMedicine(medicine.getMedicineName(),
                medicine.getMedicineType(),
        medicine.getQuantity(),
        treatmentId);
        
        id = medicine.getMedicineID();
        medicineGlobal = medicine;
        Assert.assertNotNull(medicineGlobal);
    }
}

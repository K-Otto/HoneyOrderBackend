/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;

import org.junit.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.conf.factory.MedicineFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
/**
 *
 * @author Ancel
 */
public class TestMedicine {
    @Test
    public void testCreate() throws Exception{
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Long treatmentID = treatment.getTreatmentID();
        Medicine medicine = MedicineFactory
                .createMedicine("Amoxicillin", "Antibiotic", 100, treatmentID);
        Assert.assertEquals("Amoxicillin", medicine.getMedicineName());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Long treatmentID = treatment.getTreatmentID();
       Medicine medicine = MedicineFactory
                .createMedicine("Amoxicillin", "Antibiotic", 100, treatmentID);
       Medicine copiedMedicine = new Medicine.Builder("Ampicillin").copy(medicine).build();
       Assert.assertEquals("Amoxicillin", medicine.getMedicineName());
       Assert.assertEquals("Amoxicillin", copiedMedicine.getMedicineName());
    }
}

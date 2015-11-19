/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
/**
 *
 * @author Ancel
 */
public class TestTreatment {
    @Test
    public void testCreate() throws Exception{
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Assert.assertEquals("22/07/2015", treatment.getDateAdmitted());
    }
    
    @Test
    public void testUpdate() throws Exception {
         Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Treatment copiedTreatment = new Treatment
                .Builder("29/07/2015")
                .copy(treatment)
                .build();
        Assert.assertEquals("22/07/2015", treatment.getDateAdmitted());
        Assert.assertEquals("22/07/2015", copiedTreatment.getDateAdmitted());
    }
}

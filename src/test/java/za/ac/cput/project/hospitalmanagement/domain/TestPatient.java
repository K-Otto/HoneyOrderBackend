/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;

import org.junit.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.conf.factory.*;
/**
 *
 * @author Ancel
 */
public class TestPatient {
    @Test
    public void testCreate() throws Exception{
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Long treatmentID = treatment.getTreatmentID();
        Person person = PersonFactory
                .createPerson("Doe", "John", 25, "Male");       
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        Bed bed = BedFactory
                .createBed("Available", room);
        Patient patient = PatientFactory
                .createPatient(person, "Chemotherapy", bed, treatmentID);
        Assert.assertEquals("Chemotherapy", patient.getDescription());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Long treatmentID = treatment.getTreatmentID();
        Person person = PersonFactory
                .createPerson("Doe", "John", 25, "Male");       
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        Bed bed = BedFactory
                .createBed("Available", room);
        Patient patient = PatientFactory
                .createPatient(person, "Chemotherapy", bed , treatmentID);
        
        Patient copiedPatient = new Patient
                .Builder(person)
                .description("Heart Surgery")
                .copy(patient)
                .build();
        Assert.assertEquals("Chemotherapy", patient.getDescription());
        Assert.assertEquals("Chemotherapy", copiedPatient.getDescription());
    }
}

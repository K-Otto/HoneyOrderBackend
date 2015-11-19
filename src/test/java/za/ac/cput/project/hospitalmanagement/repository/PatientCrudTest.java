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
import za.ac.cput.project.hospitalmanagement.conf.factory.*;
import za.ac.cput.project.hospitalmanagement.domain.*;
/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PatientCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private PatientRepository repository;
    
    
    @Test
    public void create() throws Exception {  
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
        repository.save(patient);
        id=patient.getPatientID();
        Assert.assertNotNull(patient.getPatientID());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Patient patient = repository.findOne(id);
        Assert.assertEquals("Chemotherapy", patient.getDescription());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Person person = PersonFactory
                .createPerson("Doe", "John", 25, "Male");
        Patient patient = repository.findOne(id);
        Patient newPatient = new Patient
                .Builder(person)
                .description("Heart Surgery")
                .copy(patient)
                .build();
        repository.save(newPatient);
        Patient updatedPatient = repository.findOne(id);
        Assert.assertEquals(updatedPatient.getDescription(), "Chemotherapy");
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Patient patient = repository.findOne(id);
        repository.delete(patient);
        Patient deletedPatient = repository.findOne(id);
        Assert.assertNull(deletedPatient);
    }
}

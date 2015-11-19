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
import za.ac.cput.project.hospitalmanagement.conf.factory.BedFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.PatientFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.PersonFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.RoomFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
import za.ac.cput.project.hospitalmanagement.domain.Bed;
import za.ac.cput.project.hospitalmanagement.domain.Patient;
import za.ac.cput.project.hospitalmanagement.domain.Person;
import za.ac.cput.project.hospitalmanagement.domain.Room;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
import za.ac.cput.project.services.PatientServices;
/**
 *
 * @author Ancel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class PatientServicesTest extends AbstractTestNGSpringContextTests{
    private Long id;
     private Patient patientGlobal;
    
    @Autowired
    private PatientServices service;
    
     @Test
    public void create() throws Exception {
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Long treatmentID = treatment.getTreatmentID();
        Person person = PersonFactory
                .createPerson("Grey", "Merideth", 25, "Female");       
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        Bed bed = BedFactory
                .createBed("Unavailable", room);
        Patient patient = PatientFactory
                .createPatient(person, "Chemotherapy", bed, treatmentID);
        service.savePatient(person.getFirstName(),
                person.getLastName(),
        person.getGender(),
        person.getAge(),
        patient.getDescription(),
        treatment.getDateAdmitted(),
        treatment.getDateDischarged());
        id = patient.getPatientID();
        patientGlobal = patient;
        Assert.assertNotNull(patientGlobal);
    }
}

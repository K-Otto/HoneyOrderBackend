/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.Bed;
import za.ac.cput.project.hospitalmanagement.domain.Patient;
import za.ac.cput.project.hospitalmanagement.domain.Person;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;

/**
 *
 * @author Ancel
 */
public class PatientFactory {
    public static Patient createPatient(Person person, String description, Bed bed, Long treatmentID) {
        Patient patient = new Patient
                .Builder(person)
                .description(description)
                .bed(bed)
                .treatmentID(treatmentID)
                .build();
        return patient;
    }
}

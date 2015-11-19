/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.Patient;

/**
 *
 * @author Ancel
 */
public interface PatientRepository extends CrudRepository <Patient, Long>{
    public Patient findByPatientID(long patientID);
}

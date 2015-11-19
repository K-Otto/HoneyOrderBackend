/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.services;

import java.util.List;
import za.ac.cput.project.hospitalmanagement.domain.Patient;

/**
 *
 * @author Ancel
 */
public interface PatientServices {
    String savePatient(String firstName,
            String lastName,
            String gender,
            int age,
            String description,
            String dateAdmitted,
            String dateDischarged
            );
    
    Patient getPatient(Long id);
    
    void deletePatient(Long id);
    
    String updatePatient(String firstName,
            String lastName,
            String gender,
            int age,
            String description,
//            String dateAdmitted,
//            String dateDischarged,
            Long id,
            Long treatmentID
            );
    
    List<Patient>  getAll();
}

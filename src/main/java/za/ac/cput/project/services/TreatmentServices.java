/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.services;

import java.util.List;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;

/**
 *
 * @author Ancel
 */
public interface TreatmentServices {
    String saveTreatment(String dateAdmitted,
            String dateDischarged
            );
    
    Treatment getTreatment(Long id);
    
    void deleteTreatment(Long id);
    
    String updateTreatment(String dateAdmitted,
            String dateDischarged,
            Long id
            );
    
    List<Treatment>  getAll();
}

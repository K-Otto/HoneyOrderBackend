/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.services;

import java.util.List;
import za.ac.cput.project.hospitalmanagement.domain.Medicine;

/**
 *
 * @author Ancel
 */
public interface MedicineServices {
    String saveMedicine(String medicineName,
            String medicineType,
            float quantity,
            Long treatmentID
            );
    
    Medicine getMedicine(Long id);
    
    void deleteMedicine(Long id);
    
    String updateMedicine(String medicineName,
            String medicineType,
            float quantity,
            Long medicineID,
            Long id
            );
    
    List<Medicine>  getAll();
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.Medicine;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;

/**
 *
 * @author Ancel
 */
public class MedicineFactory {
    public static Medicine createMedicine(String medicineName, String medicineType, float quantity, Long treatmentID) {
       Medicine medicine = new Medicine
               .Builder(medicineName)
               .medicineType(medicineType)
               .quantity(quantity)
               .treatmentID(treatmentID)
               .build();
       return medicine;
    }
}

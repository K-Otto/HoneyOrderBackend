/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.Medicine;

/**
 *
 * @author Ancel
 */
public interface MedicineRepository extends CrudRepository <Medicine, Long>{
    public Medicine findByMedicineID(long medicineID);
}

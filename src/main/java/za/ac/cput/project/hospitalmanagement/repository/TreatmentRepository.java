/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;

/**
 *
 * @author Ancel
 */
public interface TreatmentRepository extends CrudRepository <Treatment, Long>{
    public Treatment findByTreatmentID(long treatmentID);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.Operation;


/**
 *
 * @author Ancel
 */
public interface OperationRepository extends CrudRepository <Operation, Long>{
    public Operation findByOperationID(long operationID);
}

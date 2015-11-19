/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.OperationTheatre;

/**
 *
 * @author Ancel
 */
public interface OperationTheatreRepository extends CrudRepository <OperationTheatre, Long>{
    public OperationTheatre findByTheatreNo(long theatreNo);
}

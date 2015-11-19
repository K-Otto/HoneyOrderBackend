/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.Bed;

/**
 *
 * @author Ancel
 */
public interface BedRepository extends CrudRepository <Bed, Long>{
    public Bed findByBedNo(long bedNo);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;
import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.Orderline;
/**
 *
 * @author Ancel
 */
public interface OrderlineRepository extends CrudRepository <Orderline, Long>{
    public Orderline findByOrderlineId(long orderline);

}

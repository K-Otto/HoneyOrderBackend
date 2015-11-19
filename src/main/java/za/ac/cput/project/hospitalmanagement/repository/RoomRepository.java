/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.Room;

/**
 *
 * @author Ancel
 */
public interface RoomRepository extends CrudRepository <Room, Long>{
    public Room findByRoomID(long roomID);

}

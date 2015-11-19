/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import java.util.*;
import za.ac.cput.project.hospitalmanagement.domain.Bed;
import za.ac.cput.project.hospitalmanagement.domain.Person;
import za.ac.cput.project.hospitalmanagement.domain.Room;

/**
 *
 * @author Ancel
 */
public class RoomFactory {
    public static Room createRoom(int totalBeds, int availableBeds, String roomType) {
        Room room = new Room
                .Builder(totalBeds)
                .availableBeds(availableBeds)
                .roomType(roomType)
                .build();
        return room;
    }
}

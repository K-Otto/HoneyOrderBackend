/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.Bed;
import za.ac.cput.project.hospitalmanagement.domain.Room;

/**
 *
 * @author Ancel
 */
public class BedFactory {
    public static Bed createBed(String availability, Room room) {
        Bed bed = new Bed
                .Builder(availability)
                .roomID(room)
                .build();
        return bed;
    }
}

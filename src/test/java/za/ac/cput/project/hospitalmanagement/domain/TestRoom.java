/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.conf.factory.BedFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.RoomFactory;

/**
 *
 * @author Ancel
 */
public class TestRoom {
    @Test
    public void testCreate() throws Exception{
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        Bed bed = BedFactory
                .createBed("Available", room);
        Assert.assertEquals("Large", room.getRoomType());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        
        Room copiedRoom = new Room
                .Builder(50)
                .availableBeds(40)
                .copy(room)
                .roomType("Medium")
                .build();
        
        Assert.assertEquals(50, room.getAvailableBeds());
        Assert.assertEquals(50, copiedRoom.getAvailableBeds());
        Assert.assertEquals("Large", room.getRoomType());
        Assert.assertEquals("Medium", copiedRoom.getRoomType());
    }
}

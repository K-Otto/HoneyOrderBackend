/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.App;
import za.ac.cput.project.hospitalmanagement.conf.factory.BedFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.RoomFactory;
import za.ac.cput.project.hospitalmanagement.domain.Bed;
import za.ac.cput.project.hospitalmanagement.domain.Room;

/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RoomCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private RoomRepository repository;
    
    @Test
    public void create() throws Exception {
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        Bed bed = BedFactory
                .createBed("Available", room);
        repository.save(room);
        id=room.getRoomID();
        Assert.assertNotNull(room.getRoomID());
        System.out.println(room.getRoomID());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Room room = repository.findOne(id);
        Assert.assertEquals("Large",room.getRoomType());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Room room = repository.findOne(id);
        Room newRoom = new Room
                .Builder(50)
                .availableBeds(40)
                .copy(room)
                .roomType("Medium")
                .build();
        repository.save(newRoom);
        Room updatedRoom = repository.findOne(id);
        Assert.assertEquals(updatedRoom.getRoomType(), "Medium");
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Room room = repository.findOne(id);
        repository.delete(room);
        Room deletedRoom = repository.findOne(id);
        Assert.assertNull(deletedRoom);
    }
}

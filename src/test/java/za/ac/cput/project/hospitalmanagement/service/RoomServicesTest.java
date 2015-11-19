/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.App;
import za.ac.cput.project.hospitalmanagement.conf.factory.RoomFactory;
import za.ac.cput.project.hospitalmanagement.domain.Room;
import za.ac.cput.project.services.RoomServices;
/**
 *
 * @author Ancel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RoomServicesTest extends AbstractTestNGSpringContextTests{
    private Long id;
     private Room roomGlobal;
    
    @Autowired
    private RoomServices service;
    
     @Test
     public void create() throws Exception {
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        service.saveRoom(room.getTotalBeds(),
                room.getAvailableBeds(),
        room.getRoomType());
        id = room.getRoomID();
        roomGlobal = room;
        Assert.assertNotNull(roomGlobal);
    }
}

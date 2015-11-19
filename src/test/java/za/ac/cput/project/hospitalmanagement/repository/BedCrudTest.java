/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
public class BedCrudTest extends AbstractTestNGSpringContextTests{
     private long id;
    @Autowired
    private BedRepository repository;
    
    
    @Test
    public void create() throws Exception {  
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        Bed bed = BedFactory
                .createBed("Available", room);
        repository.save(bed);
        id=bed.getBedNo();
        Assert.assertNotNull(bed.getBedNo());
        System.out.println(bed.getBedNo());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Bed bed = repository.findOne(id);
        Assert.assertEquals("Available", bed.getAvailability());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Bed bed = repository.findOne(id);
        Bed newBed = new Bed
                .Builder("Unavailable")
                .copy(bed)
                .build();
        repository.save(newBed);
        Bed updatedBed = repository.findOne(id);
        Assert.assertEquals(updatedBed.getAvailability(), "Available");
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Bed bed = repository.findOne(id);
        repository.delete(bed);        
        Bed deletedBed = repository.findOne(id);
        Assert.assertNull(deletedBed);
    }
}

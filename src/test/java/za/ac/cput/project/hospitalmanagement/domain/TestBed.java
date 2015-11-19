/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.*;
import za.ac.cput.project.hospitalmanagement.conf.factory.BedFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.RoomFactory;

/**
 *
 * @author Ancel
 */
public class TestBed {   
    @Test
    public void testCreate() throws Exception{
        
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        Bed bed = BedFactory
                .createBed("Available", room);
        Assert.assertEquals("Available", bed.getAvailability());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        Bed bed = BedFactory
                .createBed("Available", room);
        
        Bed copiedBed = new Bed.Builder("Unavailable").copy(bed).build();
        Assert.assertEquals("Available", bed.getAvailability());
        Assert.assertEquals("Available", copiedBed.getAvailability());
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.*;
import za.ac.cput.project.hospitalmanagement.conf.factory.OperationTheatreFactory;

/**
 *
 * @author Ancel
 */
public class TestOperationTheatre {
    @Test
    public void testCreate() throws Exception{
        OperationTheatre operationTheatre = OperationTheatreFactory
                .createOperationTheatre("Small");
        Assert.assertEquals("Small", operationTheatre.getOperationRoomSize());
    }
    
    @Test
    public void testUpdate() throws Exception {
        OperationTheatre operationTheatre = OperationTheatreFactory
                .createOperationTheatre("Small");
        OperationTheatre copiedOperationTheatre = new OperationTheatre
                .Builder("Large")
                .copy(operationTheatre)
                .build();
        
        Assert.assertEquals("Small", operationTheatre.getOperationRoomSize());
        Assert.assertEquals("Small", copiedOperationTheatre.getOperationRoomSize());
    }
}

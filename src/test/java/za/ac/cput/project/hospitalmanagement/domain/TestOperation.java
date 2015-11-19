/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;

import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.*;
import za.ac.cput.project.hospitalmanagement.conf.factory.OperationFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.OperationTheatreFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
/**
 *
 * @author Ancel
 */
public class TestOperation {
    @Test
    public void testCreate() throws Exception{
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        OperationTheatre operationTheatre = OperationTheatreFactory
                .createOperationTheatre("Small");
        Operation operation = OperationFactory
                .createOperation("12:00", operationTheatre, treatment);
        Assert.assertEquals("12:00", operation.getStartTime());
    }
    
    public void testUpdate() throws Exception {
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        OperationTheatre operationTheatre = OperationTheatreFactory
                .createOperationTheatre("Small");
        Operation operation = OperationFactory
                .createOperation("12:00", operationTheatre, treatment);
        Operation copiedOperation = new Operation
                .Builder("09:00")
                .copy(operation)
                .build();
        Assert.assertEquals("12:00", operation.getStartTime());
        Assert.assertEquals("12:00", copiedOperation.getStartTime());
    }
}

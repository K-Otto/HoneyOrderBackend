/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.Operation;
import za.ac.cput.project.hospitalmanagement.domain.OperationTheatre;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;

/**
 *
 * @author Ancel
 */
public class OperationFactory {
     public static Operation createOperation(String startTime, OperationTheatre operationTheatre, Treatment treatment) {
        Operation operation = new Operation
                .Builder(startTime)
                .theatreNo(operationTheatre)
                .treatment(treatment)
                .build();
        return operation;
     }
    
}

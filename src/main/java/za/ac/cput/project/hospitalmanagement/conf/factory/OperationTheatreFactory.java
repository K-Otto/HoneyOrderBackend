/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.OperationTheatre;

/**
 *
 * @author Ancel
 */
public class OperationTheatreFactory {
    public static OperationTheatre createOperationTheatre(String operationRoomSize) {
        OperationTheatre operationTheatre = new OperationTheatre
                .Builder(operationRoomSize)
                .build();
        return operationTheatre;
    }
}

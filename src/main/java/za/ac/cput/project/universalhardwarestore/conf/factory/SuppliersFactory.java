/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import za.ac.cput.project.universalhardwarestore.domain.Address;
import za.ac.cput.project.universalhardwarestore.domain.Suppliers;


/**
 *
 * @author Garran
 */
public class SuppliersFactory {
    public static Suppliers createSupplier(Address address,String supplierName,String supplierNumber,String supplierEmail){
    
    Suppliers supplier = new Suppliers
                .Builder(supplierName)
                .address(address)
                .supplierNumber(supplierNumber)
                .supplierEmail(supplierEmail)
                .build();
        return supplier;
    }
}

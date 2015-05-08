/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import za.ac.cput.project.universalhardwarestore.domain.Address;

/**
 *
 * @author Garran
 */
public class AddressFactory {
    public static Address createAddress(String addressLine1,String addressLine2,String suburb,String city,String provence,String postalCode){
    
    Address address = new Address
                .Builder(addressLine1)
                .addressLine2(addressLine2)
                .suburb(suburb)
                .city(city)
                .provence(provence)
                .postalCode(postalCode)
                .build();
        return address;
    }
}

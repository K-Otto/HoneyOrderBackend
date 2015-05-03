/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.List;
import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.Address;

/**
 *
 * @author Garran
 */
public class AddressFactory {
    public static Address createAddress(
        Map<String,String> values,
        List<Address> customer){
            Address account = new Address
            .Builder(values.get("21 Vent Road"))
            .addressLine2(values.get(""))
            .suburb(values.get("Muizenberg"))
            .city(values.get("Cape Town"))
            .provence(values.get("Western Cape"))
            .postalCode(values.get("7945"))
            .build();
    return account;
    }
}

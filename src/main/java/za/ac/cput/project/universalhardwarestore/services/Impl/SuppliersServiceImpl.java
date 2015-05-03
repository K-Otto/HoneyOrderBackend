/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.services.Impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.Suppliers;
import za.ac.cput.project.universalhardwarestore.repository.SuppliersRepository;
import za.ac.cput.project.universalhardwarestore.services.SuppliersService;

/**
 *
 * @author Garran
 */
public class SuppliersServiceImpl implements SuppliersService{
    @Autowired
    SuppliersRepository repository;
    public List<Suppliers> getSuppliers() {
        List<Suppliers> allSuppliers = new ArrayList<Suppliers>();
         
        Iterable<Suppliers> supplierss = repository.findAll();
        for (Suppliers suppliers : supplierss) {
            allSuppliers.add(suppliers);
        }
        return allSuppliers;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
import za.ac.cput.project.hospitalmanagement.repository.TreatmentRepository;
import za.ac.cput.project.services.TreatmentServices;
/**
 *
 * @author Ancel
 */
@Service
public class TreatmentServiceImpl implements TreatmentServices{
    @Autowired
    TreatmentRepository repository;
    
    
    @Override
    public String saveTreatment(String dateAdmitted,
            String dateDischarged) {
        Treatment treatment = TreatmentFactory
                .createTreatment(dateAdmitted, dateDischarged);
        return repository.save(treatment).toString();
    }
    
    @Override
    public Treatment getTreatment(Long id)
    {     
        return repository.findOne(id);
    }
    
    @Override
    public void deleteTreatment(Long id)
    {
        Treatment treatment = repository.findOne(id);
        repository.delete(treatment);
    }
    
    @Override
    public String updateTreatment(String dateAdmitted,
            String dateDischarged,
            Long id) {
        Treatment treatment = repository.findOne(id);
        Treatment newTreatment = new Treatment
                .Builder(dateAdmitted)
                .dateDischarged(dateDischarged)
                .treatmentID(id)
                .build();
        return repository.save(newTreatment).toString();
    }
    
    @Override
    public List<Treatment> getAll() {
        
        return (List<Treatment>) repository.findAll();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.hospitalmanagement.conf.factory.MedicineFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
import za.ac.cput.project.hospitalmanagement.domain.Medicine;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
import za.ac.cput.project.hospitalmanagement.repository.MedicineRepository;
import za.ac.cput.project.hospitalmanagement.repository.TreatmentRepository;
import za.ac.cput.project.services.MedicineServices;
/**
 *
 * @author Ancel
 */
@Service
public class MedicineServiceImpl implements MedicineServices{
    @Autowired
    MedicineRepository repository;
    
    @Autowired
    TreatmentRepository treatmentRepository;
    
    @Override
    public String saveMedicine(String medicineName,
            String medicineType,
            float quantity,
            Long treatmentID
            ){
//        Treatment treatment =  treatmentRepository.findOne(id);
        Medicine medicine = MedicineFactory
                .createMedicine(medicineName, medicineType, quantity, treatmentID);
        return repository.save(medicine).toString();
    }
    
    @Override
    public Medicine getMedicine(Long id) {
        
        return repository.findOne(id);
    }
    
    @Override
    public void deleteMedicine(Long id)
    {
        Medicine medicine = repository.findOne(id);
        repository.delete(medicine);
    }
    
    @Override
    public String updateMedicine(String medicineName,
            String medicineType,
            float quantity,
            Long medicineID,
            Long id
            )
    {
        Medicine medicine = repository.findOne(id);
        Medicine newMedicine = new Medicine
                .Builder(medicineName)
                .medicineType(medicineType)
                .quantity(quantity)
                .treatmentID(medicineID)
                .medicineID(id)
                .build();
        return repository.save(newMedicine).toString();
        
    }
    
    @Override
    public List<Medicine> getAll() {
        
        return (List<Medicine>) repository.findAll();
    }
}

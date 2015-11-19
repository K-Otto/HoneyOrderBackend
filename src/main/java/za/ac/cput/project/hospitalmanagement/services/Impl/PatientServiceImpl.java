/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.cput.project.hospitalmanagement.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.hospitalmanagement.conf.factory.BedFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.PatientFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.PersonFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.RoomFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
import za.ac.cput.project.hospitalmanagement.domain.Bed;
import za.ac.cput.project.hospitalmanagement.domain.Patient;
import za.ac.cput.project.hospitalmanagement.domain.Person;
import za.ac.cput.project.hospitalmanagement.domain.Room;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
import za.ac.cput.project.hospitalmanagement.repository.PatientRepository;
import za.ac.cput.project.hospitalmanagement.repository.TreatmentRepository;
import za.ac.cput.project.services.PatientServices;

/**
 *
 * @author Ancel
 */
@Service
public class PatientServiceImpl implements PatientServices{
    @Autowired
    PatientRepository repository;
    
    @Autowired
    TreatmentRepository treatmentRepository;
    
    @Override
    public String savePatient(String firstName,
            String lastName,
            String gender,
            int age,
            String description,
            String dateAdmitted,
            String dateDischarged
            ){
        Treatment treatment = TreatmentFactory
                .createTreatment(dateAdmitted, dateDischarged);
        treatmentRepository.save(treatment);
        Long treatmentID = treatment.getTreatmentID();
        Person person = PersonFactory
                .createPerson(firstName, lastName, age, gender);       
        Room room = RoomFactory
                .createRoom(50, 50, "Large");
        Bed bed = BedFactory
                .createBed("Unavailable", room);
        Patient patient = PatientFactory
                .createPatient(person, description, bed, treatmentID);
        
        return repository.save(patient).toString();
    }
    
    @Override
    public Patient getPatient(Long id) {
        
        return repository.findOne(id);
    }
    
    @Override
    public void deletePatient(Long id)
    {
        Patient patient = repository.findOne(id);
        repository.delete(patient);
    }
    
    @Override
    public String updatePatient(String firstName,
            String lastName,
            String gender,
            int age,
            String description,
            /*String dateAdmitted,
            String dateDischarged,*/
            Long id,
            Long treatmentID
            ){
        Person person = PersonFactory
                .createPerson(firstName, lastName, age, gender);
        
//        Treatment treatment = TreatmentFactory
//                .createTreatment(dateAdmitted, dateDischarged);
//        Long treatmentID = treatment.getTreatmentID();
//        Treatment newTreatment = new Treatment
//                .Builder(dateAdmitted)
//                .dateDischarged(dateDischarged)
//                .treatmentID(treatmentID)
//                .build();
//       treatmentRepository.save(newTreatment);
        Patient patient = repository.findOne(id);
        Patient newPatient = new Patient
                .Builder(person)
                .description(description)
                .treatmentID(treatmentID)
                .patientID(id)
                .build();
        return repository.save(newPatient).toString();
        
    }
    
    @Override
    public List<Patient> getAll() {
        
        return (List<Patient>) repository.findAll();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.services.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.hospitalmanagement.conf.factory.EmployeeFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.PersonFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
import za.ac.cput.project.hospitalmanagement.domain.Employee;
import za.ac.cput.project.hospitalmanagement.domain.Person;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
import za.ac.cput.project.hospitalmanagement.repository.EmployeeRepository;
import za.ac.cput.project.hospitalmanagement.repository.TreatmentRepository;
import za.ac.cput.project.services.EmployeeServices;
/**
 *
 * @author Ancel
 */
@Service
public class EmployeeServiceImpl implements EmployeeServices{
    @Autowired
    EmployeeRepository repository;
    
    @Autowired
    TreatmentRepository treatmentRepository;
    
    
    @Override
    public String saveEmployee(String firstName,
            String lastName,
            String gender,
            int age,
            String qualification,
            String employeeType,
            String dateAdmitted,
            String dateDischarged) {
        /*Treatment treatment = TreatmentFactory
                .createTreatment(dateAdmitted, dateDischarged);*/
        Long treatmentId = Long.parseLong(1 + "");
        Treatment treatment =  treatmentRepository.findOne(treatmentId);
        Person person = PersonFactory
                .createPerson(firstName, lastName, age, gender);
        Employee employee = EmployeeFactory
                .createEmployee(person, qualification, employeeType, treatment);
        return repository.save(employee).toString();
    }
    
    @Override
    public Employee getEmployee(Long id) {
        
        return repository.findOne(id);
    }
    
    @Override
    public void deleteEmployee(Long id)
    {
        Employee employee = repository.findOne(id);
        repository.delete(employee);
    }
    
    @Override
    public String updateEmployee(String firstName,
            String lastName,
            String gender,
            int age,
            String qualification,
            String employeeType,
            Long id
            )
    {
        Person person = PersonFactory
                .createPerson(firstName, lastName, age, gender);
        Employee employee = repository.findOne(id);
        Employee newEmployee = new Employee
                .Builder(person)
                .employeeType(employeeType)
                .qualification(qualification)
                .employeeID(id)
                .build();        
        return repository.save(newEmployee).toString();
    }
    
    @Override
    public List<Employee> getAll() {
        
        return (List<Employee>) repository.findAll();
    }
}

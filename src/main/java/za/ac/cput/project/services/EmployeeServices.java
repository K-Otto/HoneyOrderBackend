/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.services;

import java.util.List;
import za.ac.cput.project.hospitalmanagement.domain.Employee;
import za.ac.cput.project.hospitalmanagement.domain.Person;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;

/**
 *
 * @author Ancel
 */
public interface EmployeeServices {
    String saveEmployee(String firstName,
            String lastName,
            String gender,
            int age,
            String qualification,
            String employeeType,
            String dateAdmitted,
            String dateDischarged
            );
    
    Employee getEmployee(Long id);
    
    void deleteEmployee(Long id);
    
    String updateEmployee(String firstName,
            String lastName,
            String gender,
            int age,
            String qualification,
            String employeeType,
            Long id
            );
    
    List<Employee>  getAll();
}

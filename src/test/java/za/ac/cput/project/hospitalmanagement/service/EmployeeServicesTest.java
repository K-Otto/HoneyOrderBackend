/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.App;
import za.ac.cput.project.hospitalmanagement.conf.factory.EmployeeFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.PersonFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;
import za.ac.cput.project.hospitalmanagement.domain.Employee;
import za.ac.cput.project.hospitalmanagement.domain.Person;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
import za.ac.cput.project.hospitalmanagement.repository.EmployeeRepository;
import za.ac.cput.project.services.EmployeeServices;
/**
 *
 * @author Ancel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class EmployeeServicesTest extends AbstractTestNGSpringContextTests{
     private Long id;
     private Employee employeeGlobal;
    
    @Autowired
    private EmployeeServices service;
    
    @Test
    public void create() throws Exception {
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Person person = PersonFactory
                .createPerson("Doe", "Jack", 25, "Male");
        Employee employee = EmployeeFactory
                .createEmployee(person, "MD", "Doctor", treatment);
        service.saveEmployee(person.getFirstName(),
                person.getLastName(),
        person.getGender(),
        person.getAge(),
        employee.getQualification(),
        employee.getEmployeeType(),
        treatment.getDateAdmitted(),
        treatment.getDateDischarged());
        
        /*service.saveEmployee("Merideth",
                "Grey",
        "Female",
        28,
        "MD",
        "Doctor",
        "24/07/2015",
        "24/07/2015");*/
        id = employee.getEmployeeID();
        employeeGlobal = employee;
        Assert.assertNotNull(employee);
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        // Get subject
        //String idtest = id + "";
        //Long longId = Long.parseLong(idtest);
        //Employee employee = service.getEmployee(longId);
        employeeGlobal = service.getEmployee(id);
        Assert.assertNotNull(employeeGlobal);
    }
    
}

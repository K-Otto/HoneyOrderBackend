package za.ac.cput.project.hospitalmanagement.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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

/**
 * Created by ancel on 2015/05/07.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class EmployeeCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private EmployeeRepository repository;
    
    @Test
    public void create() throws Exception {
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Person person = PersonFactory
                .createPerson("Doe", "John", 25, "Male");
        Employee employee = EmployeeFactory
                .createEmployee(person, "MD", "Doctor", treatment);
        repository.save(employee);
        id=employee.getEmployeeID();
        Assert.assertNotNull(employee.getEmployeeID());
        System.out.println(employee.getEmployeeID());

    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Employee employee = repository.findOne(id);
        Assert.assertEquals("MD",employee.getQualification());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Person person = PersonFactory
                .createPerson("Doe", "John", 25, "Male");
        Employee employee = repository.findOne(id);
        Employee newEmployee = new Employee
                .Builder(employee.getPerson())
                .copy(employee)
                .qualification("BComm")
                .employeeType(employee.getEmployeeType())
                .build();
        repository.save(newEmployee);
        Employee updatedEmployee = repository.findOne(id);
        Assert.assertEquals(updatedEmployee.getQualification(), "BComm");
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Employee employee = repository.findOne(id);
        repository.delete(employee);
        Employee deletedEmployee = repository.findOne(id);
        Assert.assertNull(deletedEmployee);
    }
}


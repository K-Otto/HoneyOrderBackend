package za.ac.cput.project.hospitalmanagement.domain;

import org.junit.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.conf.factory.EmployeeFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.PersonFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.TreatmentFactory;

/**
 * Created by Ancel on 2015/05/06.
 */
public class TestEmployee {
    @Test
    public void testCreate() throws Exception{
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Person person = PersonFactory
                .createPerson("Doe", "John", 25, "Male");
        Employee employee = EmployeeFactory
                .createEmployee(person, "MD", "Doctor", treatment);
        Assert.assertEquals("Doctor", employee.getEmployeeType());
    }

    @Test
    public void testUpdate() throws Exception {
        Treatment treatment = TreatmentFactory
                .createTreatment("22/07/2015", "24/07/2015");
        Person person = PersonFactory
                .createPerson("Doe", "John", 25, "Male");
        Employee employee = EmployeeFactory
                .createEmployee(person, "MD", "Doctor", treatment);

        Employee copiedEmployee = new Employee.Builder(person).qualification("BComm").copy(employee).employeeType("Nurse").build();
        Assert.assertEquals("MD", employee.getQualification());
        Assert.assertEquals("MD", copiedEmployee.getQualification());
        Assert.assertEquals("Doctor", employee.getEmployeeType());
        Assert.assertEquals("Nurse", copiedEmployee.getEmployeeType());
    }
}

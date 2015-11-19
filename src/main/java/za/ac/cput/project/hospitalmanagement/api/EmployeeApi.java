/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.api;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.project.hospitalmanagement.domain.Employee;
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
import za.ac.cput.project.services.EmployeeServices;
/**
 *
 * @author Ancel
 */
@RestController
@RequestMapping("/hosp/api/**")
public class EmployeeApi {
    @Autowired
    private EmployeeServices service;
    
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String SaveUsers(HttpServletRequest request){
        String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String ageString = request.getParameter("age");
            int age = Integer.parseInt(ageString);
        //Person person = request.getParameter(person);
        String qualification = request.getParameter("qualification");
            String employeeType = request.getParameter("employeeType");
           // Treatment treatment = request.getParameter(treatment);
            String dateAdmitted = request.getParameter("dateAdmitted");
            String dateDischarged = request.getParameter("dateDischarged");

        return service.saveEmployee(firstName, lastName, gender, age , qualification, employeeType , dateAdmitted, dateDischarged);
    }
    
    @RequestMapping(value="/getEmployeeDetails", method= RequestMethod.GET)
    public Employee getEmployeeDetails(HttpServletRequest request) {
        String employeeID = request.getParameter("employeeID");
        Long id = Long.parseLong(employeeID);
        return service.getEmployee(id);
    }
    
    @RequestMapping(value="/deleteEmployee", method= RequestMethod.GET)
    public String deleteEmployee(HttpServletRequest request) {
        String employeeID = request.getParameter("employeeID");
        Long id = Long.parseLong(employeeID);
        service.deleteEmployee(id);
        return "Employee record deleted";
    }
    
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
    public String updateEmployee(HttpServletRequest request){
        String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String ageString = request.getParameter("age");
            int age = Integer.parseInt(ageString);
        //Person person = request.getParameter(person);
        String qualification = request.getParameter("qualification");
            String employeeType = request.getParameter("employeeType");
           // Treatment treatment = request.getParameter(treatment);
            String employeeID = request.getParameter("employeeID");
            Long id = Long.parseLong(employeeID);
            

        return service.updateEmployee(firstName, lastName, gender, age , qualification, employeeType , id);
    }
    
    @RequestMapping(value="/getAllEmployeeDetails", method= RequestMethod.GET)
    public List<Employee> getAll(HttpServletRequest request) {
        return service.getAll();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import za.ac.cput.project.hospitalmanagement.domain.Patient;
import za.ac.cput.project.services.PatientServices;
/**
 *
 * @author Ancel
 */
@RestController
@RequestMapping("/hosp/api/**")
public class PatientApi {
    @Autowired
    private PatientServices service;
    
    @RequestMapping(value = "/addPatient", method = RequestMethod.GET)
    public String SavePatient(HttpServletRequest request){
        String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String ageString = request.getParameter("age");
            int age = Integer.parseInt(ageString);
        //Person person = request.getParameter(person);
        String description = request.getParameter("description");
           // Treatment treatment = request.getParameter(treatment);
            String dateAdmitted = request.getParameter("dateAdmitted");
            String dateDischarged = request.getParameter("dateDischarged");

        return service.savePatient(firstName, lastName, gender, age , description, dateAdmitted, dateDischarged);
    }
    
    @RequestMapping(value="/getPatientDetails", method= RequestMethod.GET)
    public Patient getPatientDetails(HttpServletRequest request) {
        String patientID = request.getParameter("patientID");
        Long id = Long.parseLong(patientID);
        return service.getPatient(id);
    }
    
    @RequestMapping(value="/deletePatient", method= RequestMethod.GET)
    public String deletePatient(HttpServletRequest request) {
        String patientID = request.getParameter("patientID");
        Long id = Long.parseLong(patientID);
        service.deletePatient(id);
        return "Patient record deleted";
    }
    
    @RequestMapping(value = "/updatePatient", method = RequestMethod.GET)
    public String updatePatient(HttpServletRequest request){
        String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String gender = request.getParameter("gender");
            String ageString = request.getParameter("age");
            int age = Integer.parseInt(ageString);
        //Person person = request.getParameter(person);
        String description = request.getParameter("description");
           // Treatment treatment = request.getParameter(treatment);
//            String dateAdmitted = request.getParameter("dateAdmitted");
//            String dateDischarged = request.getParameter("dateDischarged");
            String patientID = request.getParameter("patientID");
            Long id = Long.parseLong(patientID);
            String treatmentIDParam = request.getParameter("treatmentID");
            Long treatmentID = Long.parseLong(treatmentIDParam);

        return service.updatePatient(firstName, lastName, gender, age , description, /*dateAdmitted, dateDischarged,*/ id, treatmentID);
    }
    
    @RequestMapping(value="/getAllPatientDetails", method= RequestMethod.GET)
    public List<Patient> getAll(HttpServletRequest request) {
        return service.getAll();
    }
}

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
import za.ac.cput.project.hospitalmanagement.domain.Treatment;
import za.ac.cput.project.services.TreatmentServices;
/**
 *
 * @author Ancel
 */
@RestController
@RequestMapping("/hosp/api/**")
public class TreatmentApi {
    @Autowired
    private TreatmentServices service;
    
    @RequestMapping(value = "/addTreatment", method = RequestMethod.GET)
    public String SaveUsers(HttpServletRequest request){
            String dateAdmitted = request.getParameter("dateAdmitted");
            String dateDischarged = request.getParameter("dateDischarged");

        return service.saveTreatment(dateAdmitted, dateDischarged);
    }
    
    @RequestMapping(value="/getTreatmentDetails", method= RequestMethod.GET)
    public Treatment getTreatmentDetails(HttpServletRequest request) {
        String treatmentID = request.getParameter("treatmentID");
        Long id = Long.parseLong(treatmentID);
        return service.getTreatment(id);
    }
    
    @RequestMapping(value="/deleteTreatment", method= RequestMethod.GET)
    public String deleteTreatment(HttpServletRequest request) {
        String employeeID = request.getParameter("treatmentID");
        Long id = Long.parseLong(employeeID);
        service.deleteTreatment(id);
        return "Treatment record deleted";
    }
    
    @RequestMapping(value = "/updateTreatment", method = RequestMethod.GET)
    public String updateTreatment(HttpServletRequest request){
            String dateAdmitted = request.getParameter("dateAdmitted");
            String dateDischarged = request.getParameter("dateDischarged");
            String treatmentID = request.getParameter("treatmentID");
            Long id = Long.parseLong(treatmentID);

        return service.updateTreatment(dateAdmitted, dateDischarged, id);
    }
    
    @RequestMapping(value="/getAllTreatmentDetails", method= RequestMethod.GET)
    public List<Treatment> getAll(HttpServletRequest request) {
        return service.getAll();
    }
}

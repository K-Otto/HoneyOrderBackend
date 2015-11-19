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
import za.ac.cput.project.hospitalmanagement.domain.Medicine;
import za.ac.cput.project.services.MedicineServices;
/**
 *
 * @author Ancel
 */
@RestController
@RequestMapping("/hosp/api/**")
public class MedicineApi {
    @Autowired
    private MedicineServices service;
    
    @RequestMapping(value = "/addMedicine", method = RequestMethod.GET)
    public String SaveMedicine(HttpServletRequest request){
        String medicineName = request.getParameter("medicineName");
            String medicineType = request.getParameter("medicineType");
            String quantity = request.getParameter("quantity");
            float quantityValue = Float.parseFloat(quantity);
            String treatmentIDParam = request.getParameter("treatmentID");
            Long treatmentID = Long.parseLong(treatmentIDParam);

        return service.saveMedicine(medicineName, medicineType, quantityValue, treatmentID);
    }
    
    @RequestMapping(value="/getMedicineDetails", method= RequestMethod.GET)
    public Medicine getMedicineDetails(HttpServletRequest request) {
        String medicineID = request.getParameter("medicineID");
        Long id = Long.parseLong(medicineID);
        return service.getMedicine(id);
    }
    
    @RequestMapping(value="/deleteMedicine", method= RequestMethod.GET)
    public String deleteEmployee(HttpServletRequest request) {
        String medicineID = request.getParameter("medicineID");
        Long id = Long.parseLong(medicineID);
        service.deleteMedicine(id);
        return "Medicine record deleted";
    }
    
    @RequestMapping(value = "/updateMedicine", method = RequestMethod.GET)
    public String updateMedicine(HttpServletRequest request){
        String medicineName = request.getParameter("medicineName");
            String medicineType = request.getParameter("medicineType");
            String quantity = request.getParameter("quantity");
            float quantityValue = Float.parseFloat(quantity);
            String treatmentIDParam = request.getParameter("treatmentID");
            Long treatmentID = Long.parseLong(treatmentIDParam);
            String medicineID = request.getParameter("medicineID");
            Long id = Long.parseLong(medicineID);

        return service.updateMedicine(medicineName, medicineType, quantityValue, treatmentID, id);
    }
    
    @RequestMapping(value="/getAllMedicineDetails", method= RequestMethod.GET)
    public List<Medicine> getAll(HttpServletRequest request) {
        return service.getAll();
    }
}

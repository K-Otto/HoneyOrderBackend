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
import za.ac.cput.project.hospitalmanagement.domain.Invoice;
import za.ac.cput.project.services.InvoiceServices;
/**
 *
 * @author Ancel
 */
@RestController
@RequestMapping("/hosp/api/**")
public class InvoiceApi {
    @Autowired
    private InvoiceServices service;
    
    @RequestMapping(value = "/addInvoice", method = RequestMethod.GET)
    public String SaveInvoice(HttpServletRequest request){
        String invoiceDate = request.getParameter("invoiceDate");
        String total = request.getParameter("total");
        double totalDouble = Double.parseDouble(total);
        return service.saveInvoice(invoiceDate, totalDouble);
    }
    
    @RequestMapping(value="/getInvoice", method= RequestMethod.GET)
    public Invoice getInvoice(HttpServletRequest request) {
        String invoiceId = request.getParameter("invoiceId");
        Long id = Long.parseLong(invoiceId);
        return service.getInvoice(id);
    }
    
    @RequestMapping(value="/getAllInvoiceDetails", method= RequestMethod.GET)
    public List<Invoice> getAll(HttpServletRequest request) {
        return service.getAll();
    }
}

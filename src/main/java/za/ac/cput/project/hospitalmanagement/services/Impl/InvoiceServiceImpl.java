/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.services.Impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.hospitalmanagement.conf.factory.InvoiceFactory;
import za.ac.cput.project.hospitalmanagement.domain.Invoice;
import za.ac.cput.project.hospitalmanagement.repository.InvoiceRepository;
import za.ac.cput.project.services.InvoiceServices;
/**
 *
 * @author Ancel
 */
@Service
public class InvoiceServiceImpl implements InvoiceServices {
    @Autowired
    InvoiceRepository repository;
    
    @Override
    public String saveInvoice(String invoiceDate, double total)
    {
        Invoice invoice = InvoiceFactory
                .createInvoice(invoiceDate, total);
        return repository.save(invoice).toString();
    }
    
    @Override
    public Invoice getInvoice(Long id) {      
        return repository.findOne(id);
    }
    
    @Override
    public List<Invoice> getAll() {
        return (List<Invoice>) repository.findAll();
    }
}

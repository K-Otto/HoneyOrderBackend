/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.services;

import java.util.List;
import za.ac.cput.project.hospitalmanagement.domain.Invoice;

/**
 *
 * @author Ancel
 */
public interface InvoiceServices {
    String saveInvoice(String invoiceDate, double total);
    Invoice getInvoice(Long id);
    List <Invoice> getAll();
}

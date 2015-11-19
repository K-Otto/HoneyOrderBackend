/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.Invoice;

/**
 *
 * @author Ancel
 */
public class InvoiceFactory {
    public static Invoice createInvoice(String invoiceDate, double total) {
        Invoice invoice = new Invoice
                .Builder(invoiceDate)
                .total(total)
                .build();
        return invoice;
    }
}

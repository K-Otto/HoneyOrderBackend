/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;
import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.*;
import za.ac.cput.project.hospitalmanagement.conf.factory.InvoiceFactory;
import za.ac.cput.project.hospitalmanagement.domain.Invoice;
/**
 *
 * @author Ancel
 */
public class TestInvoice {
    @Test
    public void testCreate() throws Exception{
        Invoice invoice = InvoiceFactory
                .createInvoice("22/07/2015", 500);
        Assert.assertEquals("22/07/2015", invoice.getInvoiceDate());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Invoice invoice = InvoiceFactory
                .createInvoice("22/07/2015", 500);
        Invoice copiedInvoice = new Invoice.Builder("30/07/2015").copy(invoice).build();
        Assert.assertEquals("22/07/2015", invoice.getInvoiceDate());
        Assert.assertEquals("22/07/2015", copiedInvoice.getInvoiceDate());
    }
}

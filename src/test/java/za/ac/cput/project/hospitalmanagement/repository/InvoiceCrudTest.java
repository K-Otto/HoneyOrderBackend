/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.project.hospitalmanagement.App;
import za.ac.cput.project.hospitalmanagement.conf.factory.InvoiceFactory;
import za.ac.cput.project.hospitalmanagement.domain.Invoice;
import za.ac.cput.project.hospitalmanagement.repository.InvoiceRepository;

/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class InvoiceCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private InvoiceRepository repository;
    
    @Test
    public void create() throws Exception {  
        Invoice invoice = InvoiceFactory
                .createInvoice("22/07/2015", 500.00);
        repository.save(invoice);
        id=invoice.getInvoiceId();
        Assert.assertNotNull(invoice.getInvoiceId());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Invoice invoice = repository.findOne(id);
        Assert.assertEquals("22/07/2015", invoice.getInvoiceDate());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Invoice invoice = repository.findOne(id);
        Invoice newInvoice = new Invoice.Builder("30/07/2015").copy(invoice).build();
        repository.save(newInvoice);
        Invoice updatedInvoice = repository.findOne(id);
        Assert.assertEquals("22/07/2015", updatedInvoice.getInvoiceDate());
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Invoice invoice = repository.findOne(id);
        repository.delete(invoice);
        Invoice deletedInvoice = repository.findOne(id);
        Assert.assertNull(deletedInvoice);
    }
}

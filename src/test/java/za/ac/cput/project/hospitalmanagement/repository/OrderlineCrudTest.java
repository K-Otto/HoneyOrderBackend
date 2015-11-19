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
import za.ac.cput.project.hospitalmanagement.conf.factory.CategoryFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.InvoiceFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.OrderlineFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.ProductFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.UserFactory;
import za.ac.cput.project.hospitalmanagement.domain.Category;
import za.ac.cput.project.hospitalmanagement.domain.Invoice;
import za.ac.cput.project.hospitalmanagement.domain.Orderline;
import za.ac.cput.project.hospitalmanagement.domain.Product;
import za.ac.cput.project.hospitalmanagement.domain.User;
import za.ac.cput.project.hospitalmanagement.repository.OrderlineRepository;
/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class OrderlineCrudTest extends AbstractTestNGSpringContextTests {
    private long id;
    @Autowired
    private OrderlineRepository repository;
    
    @Test
    public void create() throws Exception {  
        Category category = CategoryFactory
                .createCategory("Liqueur");
        Product product = ProductFactory
                .createProduct("Darling Spice", "125ml", 40, category);
        User user = UserFactory
                .createUser("John123", "p@ssword", "John", "Doe");
        Invoice invoice = InvoiceFactory
                .createInvoice("22/07/2015", 500);
        Orderline orderline = OrderlineFactory
                .createOrderLine(5, 240, user, product, invoice);
        repository.save(orderline);
        id=orderline.getOrderlineId();
        Assert.assertNotNull(orderline.getOrderlineId());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Orderline orderline = repository.findOne(id);
        Assert.assertEquals(5, orderline.getQuanity());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Orderline orderline = repository.findOne(id);
        Orderline newOrderline = new Orderline.Builder(10).copy(orderline).build();
        repository.save(newOrderline);
        Orderline updatedOrderline = repository.findOne(id);
        Assert.assertEquals(5, updatedOrderline.getQuanity());
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Orderline orderline = repository.findOne(id);
        repository.delete(orderline);        
        Orderline deletedOrderline = repository.findOne(id);
        Assert.assertNull(deletedOrderline);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;
import org.junit.Assert;
import org.testng.annotations.Test;
import java.util.*;
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
/**
 *
 * @author Ancel
 */
public class TestOrderline {
    @Test
    public void testCreate() throws Exception{
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
        Assert.assertEquals(5, orderline.getQuanity());
    }
    
    @Test
    public void testUpdate() throws Exception {
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
        Orderline copiedOrderline = new Orderline.Builder(10).copy(orderline).build();
        Assert.assertEquals(5, orderline.getQuanity());
        Assert.assertEquals(5, copiedOrderline.getQuanity());
    }
}

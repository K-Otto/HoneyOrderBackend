/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.services.Impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import za.ac.cput.project.services.OrderlineServices;
/**
 *
 * @author Ancel
 */
@Service
public class OrderlineServiceImpl implements OrderlineServices{
    @Autowired
    OrderlineRepository repository;
    
    @Override
    public String saveOrderline(String categoryTitle, String productName, String productDescription, double productPrice,
            String username, String password, String firstName, String lastName, String invoiceDate, double total,
            int quantity, double price)
    {
        Category category = CategoryFactory
                .createCategory(categoryTitle);
        Product product = ProductFactory
                .createProduct(productName, productDescription, productPrice, category);
        User user = UserFactory
                .createUser(username, password, firstName, lastName);
        Invoice invoice = InvoiceFactory
                .createInvoice(invoiceDate, total);
        Orderline orderline = OrderlineFactory
                .createOrderLine(quantity, price, user, product, invoice);
        return repository.save(orderline).toString();
    }
    
    @Override
    public Orderline getOrderline(Long id) {      
        return repository.findOne(id);
    }
    
    @Override
    public void deleteOrderline(Long id)
    {
        Orderline orderline = repository.findOne(id);
        repository.delete(orderline);
    }
    
    @Override
    public List<Orderline> getAll() {
        
        return (List<Orderline>) repository.findAll();
    }
    
    @Override
    public String updateOrderline(String categoryTitle, String productName, String productDescription, double productPrice,
            String username, String password, String firstName, String lastName, String invoiceDate, double total,
            int quantity, double price, Long id)
    {
        Category category = CategoryFactory
                .createCategory(categoryTitle);
        Product product = ProductFactory
                .createProduct(productName, productDescription, productPrice, category);
        User user = UserFactory
                .createUser(username, password, firstName, lastName);
        Invoice invoice = InvoiceFactory
                .createInvoice(invoiceDate, total);
        Orderline updatedOrderline = OrderlineFactory
                .createOrderLine(quantity, price, user, product, invoice);
        Orderline orderline = repository.findOne(id);
        Orderline newOrderline = new Orderline
                .Builder(quantity)
                .price(price)
                .userId(user)
                .productId(product)
                .invoiceId(invoice)
                .orderlineId(id)
                .build();
        return repository.save(newOrderline).toString();
    }
}

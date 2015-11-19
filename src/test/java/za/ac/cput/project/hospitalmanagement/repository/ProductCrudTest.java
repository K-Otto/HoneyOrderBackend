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
import za.ac.cput.project.hospitalmanagement.conf.factory.ProductFactory;
import za.ac.cput.project.hospitalmanagement.domain.Category;
import za.ac.cput.project.hospitalmanagement.domain.Product;
import za.ac.cput.project.hospitalmanagement.repository.ProductRepository;
/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class ProductCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private ProductRepository repository;
    
    @Test
    public void create() throws Exception {  
        Category category = CategoryFactory
                .createCategory("Liqueur");
        Product product = ProductFactory
                .createProduct("Darling Spice", "125ml", 40, category);
        repository.save(product);
        id=product.getproductId();
        Assert.assertNotNull(product.getproductId());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Product product = repository.findOne(id);
        Assert.assertEquals("Darling Spice", product.getProductName());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Product product = repository.findOne(id);
        Product newProduct = new Product.Builder("Darling Honey").copy(product).build();
        repository.save(newProduct);
        Product updatedProduct = repository.findOne(id);
        Assert.assertEquals("Darling Spice", updatedProduct.getProductName());
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Product product = repository.findOne(id);
        repository.delete(product);
        Product deletedProduct = repository.findOne(id);
        Assert.assertNull(deletedProduct);
    }
}

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
import za.ac.cput.project.hospitalmanagement.conf.factory.ProductFactory;
import za.ac.cput.project.hospitalmanagement.domain.Category;
import za.ac.cput.project.hospitalmanagement.domain.Product;
/**
 *
 * @author Ancel
 */
public class TestProduct {
    @Test
    public void testCreate() throws Exception{
        Category category = CategoryFactory
                .createCategory("Liqueur");
        Product product = ProductFactory
                .createProduct("Darling Spice", "125ml", 40, category);
        Assert.assertEquals("Darling Spice", product.getProductName());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Category category = CategoryFactory
                .createCategory("Honey");
        Product product = ProductFactory
                .createProduct("Darling Spice", "125ml", 40, category);
        Product copiedProduct = new Product.Builder("Darling Honey").copy(product).build();
        Assert.assertEquals("Darling Spice", product.getProductName());
        Assert.assertEquals("Darling Spice", copiedProduct.getProductName());
    }
}

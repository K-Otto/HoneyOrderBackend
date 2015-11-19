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
import za.ac.cput.project.hospitalmanagement.domain.Category;
/**
 *
 * @author Ancel
 */
public class TestCategory {
    @Test
    public void testCreate() throws Exception{
        Category category = CategoryFactory
                .createCategory("Liqueur");
        Assert.assertEquals("Liqueur", category.getCategoryTitle());
    }
    
    @Test
    public void testUpdate() throws Exception {
        Category category = CategoryFactory
                .createCategory("Liqueur");
        Category copiedCategory = new Category.Builder("Honey").copy(category).build();
        Assert.assertEquals("Liqueur", category.getCategoryTitle());
        Assert.assertEquals("Liqueur", copiedCategory.getCategoryTitle());
    }
}

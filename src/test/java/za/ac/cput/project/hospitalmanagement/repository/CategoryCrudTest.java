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
import za.ac.cput.project.hospitalmanagement.domain.Category;
import za.ac.cput.project.hospitalmanagement.repository.CategoryRepository;
/**
 *
 * @author Ancel
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CategoryCrudTest extends AbstractTestNGSpringContextTests{
    private long id;
    @Autowired
    private CategoryRepository repository;
    
    @Test
    public void create() throws Exception {  
        Category category = CategoryFactory
                .createCategory("Liqueur");
        repository.save(category);
        id=category.getCategoryId();
        Assert.assertNotNull(category.getCategoryId());
    }
    
    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Category category = repository.findOne(id);
        Assert.assertEquals("Liqueur", category.getCategoryTitle());
    }
    
    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Category category = repository.findOne(id);
        Category newCategory = new Category.Builder("Honey").copy(category).build();
        repository.save(newCategory);
        Category updatedCategory = repository.findOne(id);
        Assert.assertEquals("Liqueur", updatedCategory.getCategoryTitle());
    }
    
    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Category category = repository.findOne(id);
        repository.delete(category);
        Category deletedCategory = repository.findOne(id);
        Assert.assertNull(deletedCategory);
    }
}

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
import za.ac.cput.project.hospitalmanagement.conf.factory.UserFactory;
import za.ac.cput.project.hospitalmanagement.domain.Category;
import za.ac.cput.project.hospitalmanagement.domain.User;
import za.ac.cput.project.hospitalmanagement.repository.CategoryRepository;
import za.ac.cput.project.services.CategoryServices;
/**
 *
 * @author Ancel
 */
@Service
public class CategoryServiceImpl implements CategoryServices{
    @Autowired
    CategoryRepository repository;
    
    @Override
    public String saveCategory(String categoryTitle)
    {
        Category category = CategoryFactory
                .createCategory(categoryTitle);
        return repository.save(category).toString();
    }
    
    @Override
    public Category getCategory(Long id) {      
        return repository.findOne(id);
    }
    
    @Override
    public void deleteCategory(Long id)
    {
        Category category = repository.findOne(id);
        repository.delete(category);
    }
    
    @Override
    public Category getCategoryByCategoryTitle(String categoryTitle)
    {
        return repository.findByCategoryTitle(categoryTitle);
    }
    
    @Override
    public List<Category> getAll() {
        
        return (List<Category>) repository.findAll();
    }
    
    @Override
    public String updateCategory(String title, Long id)
    {
        Category updatedCategory = CategoryFactory
                .createCategory(title);
        Category category = repository.findOne(id);
        Category newCategory = new Category
                .Builder(title)
                .categoryId(id)
                .build();
        return repository.save(newCategory).toString();
    }
}

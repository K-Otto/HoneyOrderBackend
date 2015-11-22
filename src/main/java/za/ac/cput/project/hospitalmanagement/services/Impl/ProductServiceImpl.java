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
import za.ac.cput.project.hospitalmanagement.conf.factory.ProductFactory;
import za.ac.cput.project.hospitalmanagement.domain.Category;
import za.ac.cput.project.hospitalmanagement.domain.Product;
import za.ac.cput.project.hospitalmanagement.repository.CategoryRepository;
import za.ac.cput.project.hospitalmanagement.repository.ProductRepository;
import za.ac.cput.project.services.ProductServices;
/**
 *
 * @author Ancel
 */
@Service
public class ProductServiceImpl implements ProductServices{
    @Autowired
    ProductRepository repository;
    
    @Autowired
    CategoryRepository categoryRepository;
    
    @Override
    public String saveProduct(String categoryTitle, String productName, String productDescription, double price)
    {
        Category category = categoryRepository.findByCategoryTitle(categoryTitle);
        
        Product product = ProductFactory
                .createProduct(productName, productDescription, price, category);
        return repository.save(product).toString();
    }
    
    @Override
    public Product getProduct(Long id) {      
        return repository.findOne(id);
    }
    
    @Override
    public void deleteProduct(Long id)
    {
        Product product = repository.findOne(id);
        repository.delete(product);
    }
    
    @Override
    public Product getProductByProductName(String productName)
    {
        return repository.findByProductName(productName);
    }
    
    @Override
    public List<Product> getAll() {
        
        return (List<Product>) repository.findAll();
    }
    
    @Override
    public String updateProduct(String categoryTitle, String productName, String productDescription, double price, Long id)
    {
        Category category = CategoryFactory
                .createCategory(categoryTitle);
        Product updatedProduct = ProductFactory
                .createProduct(productName, productDescription, price, category);
        Product product = repository.findOne(id);
        Product newProduct = new Product
                .Builder(productName)
                .productDescription(productDescription)
                .price(price)
                .categoryTitle(category)
                .productId(id)
                .build();
        return repository.save(newProduct).toString();
    }
}

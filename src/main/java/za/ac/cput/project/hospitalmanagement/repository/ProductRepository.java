/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;
import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.Product;
/**
 *
 * @author Ancel
 */
public interface ProductRepository extends CrudRepository <Product, Long>{
    public Product findByProductId(long productId);
    public Product findByProductName(String productName);

}

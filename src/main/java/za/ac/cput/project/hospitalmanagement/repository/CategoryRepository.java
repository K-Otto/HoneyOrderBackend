/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.repository;
import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.hospitalmanagement.domain.Category;
/**
 *
 * @author Ancel
 */
public interface CategoryRepository extends CrudRepository <Category, Long>{
    public Category findByCategoryId(long categoryId);
    public Category findByCategoryTitle(String categoryTitle);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.services;

import java.util.List;
import za.ac.cput.project.hospitalmanagement.domain.Category;
import za.ac.cput.project.hospitalmanagement.domain.User;

/**
 *
 * @author Ancel
 */
public interface CategoryServices {
    String saveCategory(String categoryTitle);
    Category getCategory(Long id);
    void deleteCategory(Long id);
    Category getCategoryByCategoryTitle(String categoryTitle);
    List <Category> getAll();
    String updateCategory(String title, Long id);
}

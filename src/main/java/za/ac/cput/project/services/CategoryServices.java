/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.services;

import za.ac.cput.project.hospitalmanagement.domain.Category;

/**
 *
 * @author Ancel
 */
public interface CategoryServices {
    String saveCategory(String categoryTitle);
    Category getCategory(Long id);
    void deleteCategory(Long id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.Category;

/**
 *
 * @author Ancel
 */
public class CategoryFactory {
    public static Category createCategory(String title) {
        Category category = new Category
                .Builder(title)
                .build();
        return category;
    }
}

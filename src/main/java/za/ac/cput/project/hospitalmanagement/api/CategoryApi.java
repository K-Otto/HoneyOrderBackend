/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.api;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.project.hospitalmanagement.domain.Category;
import za.ac.cput.project.hospitalmanagement.domain.Employee;
import za.ac.cput.project.services.CategoryServices;
/**
 *
 * @author Ancel
 */
@RestController
@RequestMapping("/hosp/api/**")
public class CategoryApi {
    @Autowired
    private CategoryServices service;
    
    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public String SaveCategory(HttpServletRequest request){
        String categoryTitle = request.getParameter("categoryTitle");
        return service.saveCategory(categoryTitle);
    }
    
    @RequestMapping(value="/getCategory", method= RequestMethod.GET)
    public Category getCategory(HttpServletRequest request) {
        String categoryId = request.getParameter("categoryId");
        Long id = Long.parseLong(categoryId);
        return service.getCategory(id);
    }
    
    @RequestMapping(value="/deleteCategory", method= RequestMethod.GET)
    public String deleteCategory(HttpServletRequest request) {
        String categoryId = request.getParameter("categoryId");
        Long id = Long.parseLong(categoryId);
        service.deleteCategory(id);
        return "Category record deleted";
    }
}

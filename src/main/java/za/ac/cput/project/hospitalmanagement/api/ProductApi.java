/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.api;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.project.hospitalmanagement.domain.Product;
import za.ac.cput.project.services.ProductServices;

/**
 *
 * @author Ancel
 */
@RestController
@RequestMapping("/hosp/api/**")
public class ProductApi {
    @Autowired
    private ProductServices service;
    
    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String SaveProduct(HttpServletRequest request){
        String categoryTitle = request.getParameter("categoryTitle");
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String price = request.getParameter("price");
        double priceDouble = Double.parseDouble(price);
        return service.saveProduct(categoryTitle, productName, productDescription, priceDouble);
    }
    
    @RequestMapping(value="/getProduct", method= RequestMethod.GET)
    public Product getProduct(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        Long id = Long.parseLong(productId);
        return service.getProduct(id);
    }
    
    @RequestMapping(value="/deleteProduct", method= RequestMethod.GET)
    public String deleteProduct(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        Long id = Long.parseLong(productId);
        service.deleteProduct(id);
        return "Category record deleted";
    }
    
    @RequestMapping(value="/getProductByProductName", method= RequestMethod.GET)
    public Product getUserByUsername(HttpServletRequest request) {
        String productName = request.getParameter("productName");
        return service.getProductByProductName(productName);
    }
    
    @RequestMapping(value="/getAllProductDetails", method= RequestMethod.GET)
    public List<Product> getAll(HttpServletRequest request) {
        return service.getAll();
    }
    
    @RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
    public String updateProduct(HttpServletRequest request){
        String categoryTitle = request.getParameter("categoryTitle");
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String price = request.getParameter("price");
        double priceDouble = Double.parseDouble(price);
        String productId = request.getParameter("productId");
        Long id = Long.parseLong(productId);
        return service.updateProduct(categoryTitle, productName, productDescription, priceDouble, id);
    }
    
}

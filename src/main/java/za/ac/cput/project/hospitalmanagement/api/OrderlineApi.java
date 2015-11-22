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
import za.ac.cput.project.hospitalmanagement.domain.Orderline;
import za.ac.cput.project.services.OrderlineServices;
/**
 *
 * @author Ancel
 */
@RestController
@RequestMapping("/hosp/api/**")
public class OrderlineApi {
    @Autowired
    private OrderlineServices service;
    
    @RequestMapping(value = "/addOrderline", method = RequestMethod.GET)
    public String SaveCategory(HttpServletRequest request){
        String categoryTitle = request.getParameter("categoryTitle");
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String productPrice = request.getParameter("productPrice");
        double productPriceDouble = Double.parseDouble(productPrice);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String invoiceDate = request.getParameter("invoiceDate");
        String total = request.getParameter("total");
        double totalDouble = Double.parseDouble(total);
        String quantity = request.getParameter("quantity");
        int quantityInt = Integer.parseInt(quantity);
        String price = request.getParameter("price");
        double priceDouble = Double.parseDouble(price);
        return service.saveOrderline(categoryTitle, productName, productDescription, productPriceDouble,
            username, password, firstName, lastName, invoiceDate, totalDouble,
            quantityInt, priceDouble);
    }
    
    @RequestMapping(value="/getOrderline", method= RequestMethod.GET)
    public Orderline getOrderline(HttpServletRequest request) {
        String orderlineId = request.getParameter("orderlineId");
        Long id = Long.parseLong(orderlineId);
        return service.getOrderline(id);
    }
    
    @RequestMapping(value="/deleteOrderline", method= RequestMethod.GET)
    public String deleteOrderline(HttpServletRequest request) {
        String orderlineId = request.getParameter("orderlineId");
        Long id = Long.parseLong(orderlineId);
        service.deleteOrderline(id);
        return "Oredrline record deleted";
    }
    
    @RequestMapping(value="/getAllOrderlineDetails", method= RequestMethod.GET)
    public List<Orderline> getAll(HttpServletRequest request) {
        return service.getAll();
    }
    
    @RequestMapping(value = "/updateOrderline", method = RequestMethod.GET)
    public String updateOrderline(HttpServletRequest request){
        String categoryTitle = request.getParameter("categoryTitle");
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        String productPrice = request.getParameter("productPrice");
        double productPriceDouble = Double.parseDouble(productPrice);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String invoiceDate = request.getParameter("invoiceDate");
        String total = request.getParameter("total");
        double totalDouble = Double.parseDouble(total);
        String quantity = request.getParameter("quantity");
        int quantityInt = Integer.parseInt(quantity);
        String price = request.getParameter("price");
        double priceDouble = Double.parseDouble(price); 
        String orderlineId = request.getParameter("orderlineId");
        Long id = Long.parseLong(orderlineId);
        return service.updateOrderline(categoryTitle, productName, productDescription, productPriceDouble,
            username, password, firstName, lastName, invoiceDate, totalDouble,
            quantityInt, priceDouble, id);
    }
}

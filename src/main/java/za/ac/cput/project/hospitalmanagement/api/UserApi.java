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
import za.ac.cput.project.hospitalmanagement.domain.User;
import za.ac.cput.project.services.UserServices;
import java.util.List;
/**
 *
 * @author Ancel
 */
@RestController
@RequestMapping("/hosp/api/**")
public class UserApi {
    @Autowired
    private UserServices service;
    
    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public String saveUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        return service.saveUser(username, password, firstName, lastName);
    }
    
    @RequestMapping(value="/getUserById", method= RequestMethod.GET)
    public User getUserById(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        Long id = Long.parseLong(userId);
        return service.getUserById(id);
    }
    
    @RequestMapping(value="/getUserByUsername", method= RequestMethod.GET)
    public User getUserByUsername(HttpServletRequest request) {
        String username = request.getParameter("username");
        return service.getUserByUsername(username);
    }
    
    @RequestMapping(value="/getAllUserDetails", method= RequestMethod.GET)
    public List<User> getAll(HttpServletRequest request) {
        return service.getAll();
    }
    
    @RequestMapping(value="/deleteUser", method= RequestMethod.GET)
    public String deleteEmployee(HttpServletRequest request) {
        String userId = request.getParameter("userId");
        Long id = Long.parseLong(userId);
        service.deleteUser(id);
        return "User record deleted";
    }
    
    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public String updateUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            
            String userId = request.getParameter("userId");
            Long id = Long.parseLong(userId);
            

        return service.updateUser(username, password, firstName, lastName, id);
    }
}

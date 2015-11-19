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
import za.ac.cput.project.services.RoomServices;
/**
 *
 * @author Ancel
 */
@RestController
@RequestMapping("/hosp/api/**")
public class RoomApi {
    @Autowired
    private RoomServices service;
    
    @RequestMapping(value = "/addRoom", method = RequestMethod.GET)
    public String SaveRoom(HttpServletRequest request){
            String totalBeds = request.getParameter("totalBeds");
            int totalBedsValue = Integer.parseInt(totalBeds);
            String availableBeds = request.getParameter("availableBeds");
            int availableBedsValue = Integer.parseInt(availableBeds);
            String roomType = request.getParameter("roomType");
        return service.saveRoom(totalBedsValue, availableBedsValue, roomType);
    }
}

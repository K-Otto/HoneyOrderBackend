/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.ac.cput.project.universalhardwarestore.domain.Users;
import za.ac.cput.project.universalhardwarestore.model.UsersResource;
import za.ac.cput.project.universalhardwarestore.services.UsersService;

/**
 *
 * @author Garran
 */
public class UsersPage {
    @Autowired
    private UsersService service;
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public Long getFacultyUsers(@PathVariable Long id) {


        // ...
        return service.getUser(id);
    }
//
//    @RequestMapping(value="/{id}/departments", method=RequestMethod.GET)
//    List<Department> getFacultyDepartments(@PathVariable Long id) {
//        // ...
//    }
//
    @RequestMapping(value="/faculties", method=RequestMethod.GET)

    public List<UsersResource> getFaculties() {
        List<UsersResource> hateos = new ArrayList<>();
        List<Users> users = service.getUsers();
        for (Users userss : users) {
            UsersResource res = new UsersResource
                    .Builder(userss.getUserName())
                    .password(userss.getPassword())
                    .status(userss.getStatus())
                    .resid(userss.getId())
                    .build();
            Link usersss = new
                    Link("http://localhost:8080/users/"+res.getResid().toString())
                    .withRel("depts");
            res.add(usersss);
            hateos.add(res);
        }
        return hateos;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.services.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.User;
import za.ac.cput.project.universalhardwarestore.repository.UserRepository;
import za.ac.cput.project.universalhardwarestore.services.UserService;

/**
 *
 * @author Garran
 */
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository repository;
    public List<User> getUsers() {
        List<User> allusers = new ArrayList<User>();
        Iterable<User> users = repository.findAll();
        for (User user : users) {
            allusers.add(user);
        }
        return allusers;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.services.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.project.universalhardwarestore.domain.Users;
import za.ac.cput.project.universalhardwarestore.repository.UsersRepository;
import za.ac.cput.project.universalhardwarestore.services.UsersService;

/**
 *
 * @author Garran
 */
public class UsersServiceImpl implements UsersService{
    @Autowired
    UsersRepository repository;
    public List<Users> getUsers() {
        List<Users> allusers = new ArrayList<Users>();
        Iterable<Users> users = repository.findAll();
        for (Users user : users) {
            allusers.add(user);
        }
        return allusers;
    }
}

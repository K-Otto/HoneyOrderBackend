/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.services;

import za.ac.cput.project.hospitalmanagement.domain.User;
import java.util.List;

/**
 *
 * @author Ancel
 */
public interface UserServices {
    String saveUser(String username, String password, String firstName, String lastName);  
    User getUserById(Long id);
    User getUserByUsername(String username);
    List <User> getAll();
    void deleteUser(Long id);
    String updateUser(String username, String password, String firstName, String lastName, Long id
            );
}

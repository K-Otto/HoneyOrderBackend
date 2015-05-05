/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import java.util.List;
import java.util.Map;
import za.ac.cput.project.universalhardwarestore.domain.User;

/**
 *
 * @author Garran
 */
public class UserFactory {
    public static User createUser(String userName,String password,String status){
    
    User user = new User
                .Builder(userName)
                .password(password)
                .status(status)
                .build();
        return user;
    }
}

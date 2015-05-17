/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.conf.factory;

import za.ac.cput.project.universalhardwarestore.domain.Users;

/**
 *
 * @author Garran
 */
public class UsersFactory {
    public static Users createUsers(String userName,String password,String status){
    
    Users users = new Users
                .Builder(userName)
                .password(password)
                .status(status)
                .build();
        return users;
    }
}

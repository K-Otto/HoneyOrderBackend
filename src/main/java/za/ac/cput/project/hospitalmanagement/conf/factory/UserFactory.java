/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.conf.factory;

import za.ac.cput.project.hospitalmanagement.domain.User;

/**
 *
 * @author Ancel
 */
public class UserFactory {
    public static User createUser(String username, String password, String firstName, String lastName) {
        User user = new User
                .Builder(username)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .build();
        return user;
    }
}

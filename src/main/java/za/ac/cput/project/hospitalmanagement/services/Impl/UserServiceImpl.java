/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.services.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.hospitalmanagement.conf.factory.UserFactory;
import za.ac.cput.project.hospitalmanagement.domain.User;
import za.ac.cput.project.hospitalmanagement.repository.UserRepository;
import za.ac.cput.project.services.UserServices;
import java.util.List;
/**
 *
 * @author Ancel
 */
@Service
public class UserServiceImpl implements UserServices{
    @Autowired
    UserRepository repository;
    
    @Override
    public String saveUser(String username, String password, String firstName, String lastName)
    {
        User user = UserFactory
                .createUser(username, password, firstName, lastName);
        if(repository.findByUsername(username) != null)
        {
            return "A user with that username already exists";
        }
        else
        {
            return repository.save(user).toString();
        }
        
    }
    
    @Override
    public User getUserById(Long id)
    {
        return repository.findOne(id);
    }
    
    @Override
    public User getUserByUsername(String username)
    {
        return repository.findByUsername(username);
    }
    
    @Override
    public List<User> getAll() {
        
        return (List<User>) repository.findAll();
    }
    
    @Override
    public void deleteUser(Long id)
    {
        User user = repository.findOne(id);
        repository.delete(user);
    }
    
    @Override
    public String updateUser(String username, String password, String firstName, String lastName, Long id)
    {
        User updatedUser = UserFactory
                .createUser(username, password, firstName, lastName);
        User user = repository.findOne(id);
        User newUser = new User
                .Builder(username)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .userId(id)
                .build(); 
        return repository.save(newUser).toString();
    }
}

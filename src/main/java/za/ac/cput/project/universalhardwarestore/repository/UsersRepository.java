/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.project.universalhardwarestore.domain.Users;

/**
 *
 * @author Garran
 */
public interface UsersRepository extends CrudRepository<Users,Long>{
    public Users findByUserName(String userName);
}

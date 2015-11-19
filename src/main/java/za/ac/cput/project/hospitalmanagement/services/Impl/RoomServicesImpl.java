/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.services.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.hospitalmanagement.conf.factory.BedFactory;
import za.ac.cput.project.hospitalmanagement.conf.factory.RoomFactory;
import za.ac.cput.project.hospitalmanagement.domain.Bed;
import za.ac.cput.project.hospitalmanagement.domain.Room;
import za.ac.cput.project.hospitalmanagement.repository.RoomRepository;
import za.ac.cput.project.services.RoomServices;
/**
 *
 * @author Ancel
 */
@Service
public class RoomServicesImpl implements RoomServices{
    @Autowired
    RoomRepository repository;
    
    @Override
    public String saveRoom(int totalBeds,
            int availableBeds,
            String roomType
            ){
        Room room = RoomFactory
                .createRoom(totalBeds, availableBeds, roomType);
        return repository.save(room).toString();
    }
}

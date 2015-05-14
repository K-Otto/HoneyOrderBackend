///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package za.ac.cput.project.universalhardwarestore.services.Impl;
//
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.project.universalhardwarestore.domain.Items;
//import za.ac.cput.project.universalhardwarestore.repository.ItemsRepository;
//import za.ac.cput.project.universalhardwarestore.services.ItemsService;
//
///**
// *
// * @author Garran
// */
//public class ItemsServiceImpl implements ItemsService{
//    @Autowired
//    ItemsRepository repository;
//    public List<Items> getItems() {
//    List<Items> allItems = new ArrayList<Items>();
//         
//        Iterable<Items> items = repository.findAll();
//        for (Items itemss : items) {
//            allItems.add(itemss);
//        }
//        return allItems;
//    }
//}

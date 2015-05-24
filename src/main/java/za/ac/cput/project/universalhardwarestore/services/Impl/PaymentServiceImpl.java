/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.services.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.project.universalhardwarestore.domain.Payment;
import za.ac.cput.project.universalhardwarestore.repository.PaymentRepository;
import za.ac.cput.project.universalhardwarestore.services.PaymentService;

/**
 *
 * @author Garran
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    PaymentRepository repository;
    public List<Payment> getPayment() {
        List<Payment> allPayment = new ArrayList<Payment>();
         
        Iterable<Payment> payment = repository.findAll();
        for (Payment payments : payment) {
            allPayment.add(payments);
        }
        return allPayment;
    }
    
}

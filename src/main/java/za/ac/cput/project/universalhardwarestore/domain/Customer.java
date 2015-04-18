/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Garran
 */
public class Customer implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerID;
    @Column(unique = true)
    private String phoneNumber; 
    private String email;
    
    private Customer() {
    }
    
    public Customer(Customer.Builder builder) {
        customerID=builder.customerID;
        phoneNumber=builder.phoneNumber;
        email=builder.email;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    
    public static class Builder{

        private int customerID;
        private String phoneNumber;
        private String email;
        
        public Builder(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        
        public Builder customerID(int value){
            this.customerID=value;
            return this;
        }

        public Builder email(String value){
            this.email=value;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return !(phoneNumber != null ? !phoneNumber.equals(customer.phoneNumber) : customer.phoneNumber != null);

    }
    
    @Override
    public int hashCode() {
        return phoneNumber != null ? phoneNumber.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Course{" +
                "customerID=" + customerID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

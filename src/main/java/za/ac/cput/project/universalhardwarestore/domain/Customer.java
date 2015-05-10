/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import java.util.Objects;
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
    private Long id;
    @Column(unique = true)
    private String customerID;
    private String phoneNumber; 
    private String email;
    private Users user;
    private Address address;
    private Account account;
    
    private Customer() {
    }
    
    public Customer(Customer.Builder builder) {
        customerID=builder.customerID;
        phoneNumber=builder.phoneNumber;
        email=builder.email;
        user=builder.user;
        address=builder.address;
        account=builder.account;
        id=builder.id;
    }
    
    public Long getId() {
        return id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Users getUser() {
        return user;
    }
    
    public Account getAccount() {
        return account;
    }
        
    public Address getAddress() {
        return address;
    }
    
    public static class Builder{
        private Long id;
        private String customerID;
        private String phoneNumber;
        private String email;
        private Users user;
        private Address address;
        private Account account;
        
        public Builder(String customerID) {
            this.customerID = customerID;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }
        
        public Builder phoneNumber(String value){
            this.phoneNumber=value;
            return this;
        }

        public Builder email(String value){
            this.email=value;
            return this;
        }
        
        public Builder user(Users value){
            this.user=value;
            return this;
        }
        
        public Builder address(Address value){
            this.address=value;
            return this;
        }
        
        public Builder account(Account value){
            this.account=value;
            return this;
        }
        
        public Builder copy(Customer value){
            this.account=value.account;
            this.address=value.address;
            this.customerID=value.customerID;
            this.id=value.id;
            this.phoneNumber=value.phoneNumber;
            this.user=value.user;
            return this;
        }

//        public Builder() {
//        }

        public Customer build(){
            return new Customer(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Course{" +
                "customerID=" + customerID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}

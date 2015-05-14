///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package za.ac.cput.project.universalhardwarestore.domain;
//
//import java.io.Serializable;
//import java.util.Objects;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
///**
// *
// * @author Garran
// */
//@Entity
//public class CustomerAccount implements Serializable{
//    
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    @Column(unique = true)
//    private String customerID;
//    private String phoneNumber; 
//    private String email;
//    
//    private Users users;
//    private String accountNumber;
//    private String status; 
//    private double balance;
//    private Address address;
//    
//    private CustomerAccount() {
//    }
//    
//    public CustomerAccount(CustomerAccount.Builder builder) {
//        customerID=builder.customerID;
//        phoneNumber=builder.phoneNumber;
//        email=builder.email;
//        users=builder.users;
//        address=builder.address;
//        id=builder.id;
//        accountNumber=builder.accountNumber;
//        status=builder.status;
//        balance=builder.balance;
//    }
//    
//    public Long getId() {
//        return id;
//    }
//
//    public String getCustomerID() {
//        return customerID;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public Users getUsers() {
//        return users;
//    }
//
//    public String getAccountNumber() {
//        return accountNumber;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//        
//    public Address getAddress() {
//        return address;
//    }
//    
//    public static class Builder{
//        private Long id;
//        private String customerID;
//        private String phoneNumber;
//        private String email;
//        private Users users;
//        private Address address;
//        private String accountNumber;
//        private String status; 
//        private double balance;
//        
//        public Builder(String customerID) {
//            this.customerID = customerID;
//        }
//        
//        public Builder id(Long value){
//            this.id=value;
//            return this;
//        }
//        
//        public Builder phoneNumber(String value){
//            this.phoneNumber=value;
//            return this;
//        }
//
//        public Builder email(String value){
//            this.email=value;
//            return this;
//        }
//        
//        public Builder users(Users value){
//            this.users=value;
//            return this;
//        }
//        
//        public Builder accountNumber(String value){
//            this.accountNumber=value;
//            return this;
//        }
//        
//        public Builder status(String value){
//            this.status=value;
//            return this;
//        }
//        
//        public Builder balance(double value){
//            this.balance=value;
//            return this;
//        }
//        
//        public Builder address(Address value){
//            this.address=value;
//            return this;
//        }
//        
//        public Builder copy(CustomerAccount value){
//            //this.account=value.account;
//            this.address=value.address;
//            this.customerID=value.customerID;
//            this.id=value.id;
//            this.phoneNumber=value.phoneNumber;
//            this.users=value.users;
//            this.accountNumber=value.accountNumber;
//            this.status=value.status;
//            this.balance=value.balance;
//            return this;
//        }
//        
//        public CustomerAccount build(){
//            return new CustomerAccount(this);
//        }
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 53 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final CustomerAccount other = (CustomerAccount) obj;
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "Course{" +
//                "customerID=" + customerID +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", email='" + email + '\'' +
//                ", user='" + users + '\'' +
//                ", email='" + accountNumber + '\'' +
//                ", user='" + status + '\'' +
//                ", user='" + balance + '\'' +
//                '}';
//    }
//}

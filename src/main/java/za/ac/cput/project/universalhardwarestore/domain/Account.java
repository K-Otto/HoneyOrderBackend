/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Garran
 */
public class Account implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String accountNumber;
    private String status; 
    private double balance;
    @Embedded
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="shoppingCart_id")
    private List<ShoppingCart> shoppingCart;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private List<Order> order;
    
    private Account() {
    }
    
    public Account(Account.Builder builder) {
        status=builder.status;
        balance=builder.balance;
        accountNumber=builder.accountNumber;
        customer=builder.customer;
        shoppingCart=builder.shoppingCart;
        order=builder.order;
    }
    
    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
        
    public double getBalance() {
        return balance;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public List<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }
        
    public List<Order> getOrder() {
        return order;
    }
    
    public static class Builder{
        private String accountNumber;
        private String status;
        private double balance;
        private Customer customer;
        private List<ShoppingCart> shoppingCart;
        private List<Order> order;
    
        public Builder(String accountNumber) {
            this.accountNumber = accountNumber;
        }
        
        public Builder status(String value){
            this.status=value;
            return this;
        }
        
        public Builder balance(double value){
            this.balance=value;
            return this;
        }
        
        public Builder accountNumber(String value){
            this.accountNumber=value;
            return this;
        }
        
        public Builder customer(Customer value){
            this.customer=value;
            return this;
        }
        
        public Builder shoppingCart(List<ShoppingCart> value){
            this.shoppingCart=value;
            return this;
        }
        
        public Builder order(List<Order> value){
            this.order=value;
            return this;
        }

        public Account build(){
            return new Account(this);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return !(id != null ? !id.equals(account.id) : account.id != null);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Course{" +
                ", accountNumber='" + accountNumber + '\'' +
                ", Status='" + status + '\'' +
                ", Balance='" + balance + '\'' +
                '}';
    }
}

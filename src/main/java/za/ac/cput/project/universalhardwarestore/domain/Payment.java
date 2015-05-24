/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Garran
 */
@Entity
public class Payment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String paidDate;
    private double total; 
    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name = "customerAccount_id")
    private CustomerAccount customerAccount;
    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;
    
    private Payment() {
    }

    public Long getId() {
        return id;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public double getTotal() {
        return total;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public Order getOrder() {
        return order;
    }
    
    public Payment(Builder builder) {
        this.paidDate=builder.paidDate;
        this.id=builder.id;
        this.total=builder.total;
        this.customerAccount=builder.customerAccount;
        this.order=builder.order;
    }
   
    public static class Builder{
    private Long id;
    private String paidDate;
    private double total; 
    private CustomerAccount customerAccount;
    private Order order;

        public Builder(String paidDate){
            this.paidDate=paidDate;
        }
    
        public Builder id(Long value){
            this.id=value;
            return this;
        }
                
        public Builder total(double value){
            this.total=value;
            return this;
        }
        
        public Builder customerAccount(CustomerAccount value){
            this.customerAccount=value;
            return this;
        }
        
        public Builder order(Order value){
            this.order=value;
            return this;
        }
        
        public Builder copy(Payment value){
            this.paidDate=value.paidDate;
            this.total=value.total;
            this.id=value.id;
            this.order=value.order;
            this.customerAccount=value.customerAccount;
            return this;
        }
        
        public Payment build(){
            return new Payment(this);
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 43 * hash + Objects.hashCode(this.id);
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
            final Builder other = (Builder) obj;
            if (!Objects.equals(this.id, other.id)) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Builder{" + "paidDate=" + paidDate + ", total=" + total + '}';
        }
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Garran
 */
@Entity
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderCode;
    private String dateOrdered;
    private String shippedDate;
    private String orderStatus;
    private String description;
    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name = "customerAccount_id")
    private CustomerAccount customerAccount;
    @OneToMany (cascade=CascadeType.ALL)
    @JoinColumn(name = "items_id")
    private List<Items> items;

    private Order() {
    }
    
    public Order(Builder builder) {
        this.orderCode=builder.orderCode;
        this.dateOrdered=builder.dateOrdered;
        this.id=builder.id;
        this.shippedDate=builder.shippedDate;
        this.orderStatus=builder.orderStatus;
        this.description=builder.description;
        this.customerAccount=builder.customerAccount;
        this.items=builder.items;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getDescription() {
        return description;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public List<Items> getItems() {
        return items;
    }

    public Long getId() {
        return id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public String getShippedDate() {
        return shippedDate;
    }
    
    public static class Builder{
        private Long id;
        private String orderCode;
        private String dateOrdered;
        private String shippedDate;
        private String description;
        private String orderStatus;
        private CustomerAccount customerAccount;
        private List<Items> items;

//        public Builder id(Long value){
//            this.id=value;
//            return this;
//        }
        
        public Builder(String orderCode){
            this.orderCode=orderCode;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }
        
        public Builder dateOrdered(String value){
            this.dateOrdered=value;
            return this;
        }
        
        public Builder shippedDate(String value){
            this.shippedDate=value;
            return this;
        }
        
        public Builder orderStatus(String value){
            this.orderStatus=value;
            return this;
        }
        
        public Builder description(String value){
            this.description=value;
            return this;
        }
        
        public Builder customerAccount(CustomerAccount value){
            this.customerAccount=value;
            return this;
        }
        
        public Builder items(List<Items> value){
            this.items=value;
            return this;
        }
        
        public Builder copy(Order value){
            this.orderCode=value.orderCode;
            this.dateOrdered = value.dateOrdered;
            this.id=value.id;
            this.shippedDate=value.shippedDate;
            this.orderStatus=value.orderStatus;
            this.description=value.description;
            this.customerAccount=value.customerAccount;
            this.items=value.items;
            return this;
        }
        
        public Order build(){
            return new Order(this);
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 47 * hash + Objects.hashCode(this.id);
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
    }
}

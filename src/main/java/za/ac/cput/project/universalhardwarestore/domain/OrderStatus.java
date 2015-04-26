/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Garran
 */
public class OrderStatus implements Serializable{
    private String orderStatus;
    private String description; 
    
    private OrderStatus() {
    }
    
    public OrderStatus(Builder builder) {
        orderStatus=builder.orderStatus;
        description=builder.description;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getDescription() {
        return description;
    }
    
    public static class Builder{
        private String orderStatus;
        private String description;
        
        public Builder orderStatus(String value){
            this.orderStatus=value;
            return this;
        }
        
        public Builder description(String value){
            this.description=value;
            return this;
        }
        
        public Builder copy(OrderStatus value){
            this.orderStatus=value.orderStatus;
            this.description=value.description;
            return this;
        }
        
        public OrderStatus build(){
            return new OrderStatus(this);
        }
    }
}

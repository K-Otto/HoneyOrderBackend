/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Garran
 */
@Embeddable
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String orderCode;
    private String dateOrdered;
    private String shippedDate;
    private String shipStatus;
    @Embedded
    private OrderStatus orderStatus;
    
    private Order() {
    }
    
    public Order(Builder builder) {
        this.orderCode=builder.orderCode;
        this.dateOrdered=builder.dateOrdered;
        this.id=builder.id;
        this.shippedDate=builder.shippedDate;
        this.shipStatus=builder.shipStatus;
        this.orderStatus=builder.orderStatus;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public String getOrderCode() {
//        return orderCode;
//    }
//
//    public String getDateOrdered() {
//        return dateOrdered;
//    }
//
//    public String getShippedDate() {
//        return shippedDate;
//    }
//
//    public String getShipStatus() {
//        return shipStatus;
//    }
//
//    public OrderStatus getOrderStatus() {
//        return orderStatus;
//    }
    
    public static class Builder{
        private Long id;
        private String orderCode;
        private String dateOrdered;
        private String shippedDate;
        private String shipStatus;
        private OrderStatus orderStatus;

//        public Builder id(Long value){
//            this.id=value;
//            return this;
//        }
        
        public Builder(String value){
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
        
        public Builder shipStatus(String value){
            this.shipStatus=value;
            return this;
        }
        
        public Builder orderStatus(OrderStatus value){
            this.orderStatus=value;
            return this;
        }
        
        public Builder copy(Order value){
            this.orderCode=value.orderCode;
            this.dateOrdered = value.dateOrdered;
            this.id=value.id;
            this.shippedDate=value.shippedDate;
            this.shipStatus=value.shipStatus;
            this.orderStatus=value.orderStatus;
            return this;
        }
        
        public Order build(){
            return new Order(this);
        }
    }
}

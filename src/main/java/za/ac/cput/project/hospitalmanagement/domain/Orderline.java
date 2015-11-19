/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.hospitalmanagement.domain;
import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author Ancel
 */
@Entity
public class Orderline implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderlineId;
    private int quantity;
    private double price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userId")
    private User userId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="productId")
    private Product productId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="invoiceId")
    private Invoice invoiceId;
    
    public Orderline(){

    }

    public long getOrderlineId() {
        return orderlineId;
    }

    public int getQuanity() {
        return quantity;
    }
    
    public double getPrice() {
        return price;
    }
    
    public User getUserId() {
        return userId;
    }
    
    public Product getProductId(){
        return productId;
    }
    
    public Invoice getInvoiceId(){
        return invoiceId;
    }

    public Orderline(Builder builder){
        this.orderlineId=builder.orderlineId;
        this.quantity = builder.quantity;
        this.price=builder.price;
        this.userId = builder.userId;
        this.productId = builder.productId;
        this.invoiceId = builder.invoiceId;
    }

    public static class Builder{
        private long orderlineId;
        private int quantity;
        private double price;
        private User userId;
        private Product productId;
        private Invoice invoiceId;

        public Builder(int quantity) {
            this.quantity = quantity;
        }

        public Builder price(double value){
            this.price=value;
            return this;
        }
        
        public Builder orderlineId(long value){
            this.orderlineId=value;
            return this;
        }
        
        public Builder userId(User value){
            this.userId=value;
            return this;
        }
        
        public Builder productId(Product value){
            this.productId=value;
            return this;
        }
        
        public Builder invoiceId(Invoice value){
            this.invoiceId=value;
            return this;
        }

        public Builder copy(Orderline value){
            this.orderlineId=value.orderlineId;
            this.quantity = value.quantity;
            this.price=value.price;
            this.userId=value.userId;
            this.productId=value.productId;
            this.invoiceId=value.invoiceId;
            return this;
        }

        public Orderline build(){
            return new Orderline(this);
        }
    }
}

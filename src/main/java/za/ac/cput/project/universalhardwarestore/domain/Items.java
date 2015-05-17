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
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Items implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String itemNumber;
    private int quantity; 
    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    private Stock stock;
    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn(name="shoppingCart_id")
    private ShoppingCart shoppingCart;
    
    private Items() {
    }

    public Long getId() {
        return id;
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public Stock getStock() {
        return stock;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
    
    public Items(Builder builder) {
        this.quantity=builder.quantity;
        this.id=builder.id;
        this.shoppingCart=builder.shoppingCart;
        this.itemNumber=builder.itemNumber;
        this.stock=builder.stock;
    }
   
    public static class Builder{
        private Long id;
        private String itemNumber;
        private int quantity;
        private ShoppingCart shoppingCart;
        private Stock stock;
        
        public Builder(String itemNumber){
            this.itemNumber=itemNumber;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }
        
        public Builder quantity(int value){
            this.quantity=value;
            return this;
        }
                
        public Builder shoppingCart(ShoppingCart value){
            this.shoppingCart=value;
            return this;
        }
        
        public Builder stock(Stock value){
            this.stock=value;
            return this;
        }
        
        public Builder copy(Items value){
            this.shoppingCart=value.shoppingCart;
            this.quantity=value.quantity;
            this.id=value.id;
            return this;
        }
        
        public Items build(){
            return new Items(this);
        }
    }
}

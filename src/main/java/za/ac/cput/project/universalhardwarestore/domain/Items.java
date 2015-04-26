/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Garran
 */
public class Items implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity; 
    @OneToMany
    @JoinColumn(name = "dept_id")
    private List<Stock> stock;
    @OneToMany
    @JoinColumn(name = "dept_id")
    private List<ShoppingCart> shoppingCart;
    
    private Items() {
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public List<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }
    
    public Items(Builder builder) {
        this.quantity=builder.quantity;
        this.id=builder.id;
        this.shoppingCart=builder.shoppingCart;
    }
   
    public static class Builder{
        private Long id;
        private int quantity;
        private List<ShoppingCart> shoppingCart;

        public Builder id(Long value){
            this.id=value;
            return this;
        }
        
        public Builder quantity(int value){
            this.quantity=value;
            return this;
        }
                
        public Builder shoppingCart(List<ShoppingCart> value){
            this.shoppingCart=value;
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

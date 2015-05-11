/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Garran
 */
public class ShoppingCart implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="customeraccount_id")
    @Embedded
    CustomerAccount customerAccount;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="shoppingCart_id")
    private List<Items> items;
    private String dateCreated;
    
    private ShoppingCart() {
    }

    public ShoppingCart(Builder builder) {
        id=builder.id;
        customerAccount=builder.customerAccount;
        items=builder.items;
        dateCreated=builder.dateCreated;
    }

    public Long getId() {
        return id;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public List<Items> getItems() {
        return items;
    }

    public String getDateCreated() {
        return dateCreated;
    }
    
    public static class Builder{
    private Long id;
    private CustomerAccount customerAccount;
    private List<Items> items;
    private String dateCreated;

        public Builder(String dateCreated) {
            this.dateCreated = dateCreated;
        }
        
        public Builder customerAccount(CustomerAccount value){
            this.customerAccount=value;
            return this;
        }
        
        public Builder items(List<Items> value){
            this.items=value;
            return this;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }
        
        public Builder copy(ShoppingCart value){
            this.id=value.getId();
            this.customerAccount=value.getCustomerAccount();
            this.items=value.getItems();
            this.dateCreated=value.getDateCreated();
            return this;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ShoppingCart)) return false;

            ShoppingCart shoppingCart = (ShoppingCart) o;

            return !(id != null ? !id.equals(shoppingCart.id) : shoppingCart.id != null);

        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "id=" + id +
                    ", date='" + dateCreated + '\'' +
                    '}';
        }
    }
}

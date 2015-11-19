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
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    private String productName;
    private String productDescription;
    private double price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="categoryTitle")
    private Category categoryTitle;
    
    public Product(){

    }

    public long getproductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
    
    public String getProductDescription() {
        return productDescription;
    }
    
    public double getPrice() {
        return price;
    }
    
    public Category getCategoryTitle() {
        return categoryTitle;
    }

    public Product(Builder builder){
        this.productId=builder.productId;
        this.productName = builder.productName;
        this.productDescription=builder.productDescription;
        this.price = builder.price;
        this.categoryTitle = builder.categoryTitle;
    }

    public static class Builder{
        private long productId;
        private String productName;
        private String productDescription;
        private double price;
        private Category categoryTitle;

        public Builder(String productName) {
            this.productName = productName;
        }

        public Builder productDescription(String value){
            this.productDescription=value;
            return this;
        }
        
        public Builder price(double value){
            this.price=value;
            return this;
        }
        
        public Builder productId(long value){
            this.productId=value;
            return this;
        }
        
        public Builder categoryTitle(Category value){
            this.categoryTitle=value;
            return this;
        }

        public Builder copy(Product value){
            this.productId=value.productId;
            this.productName = value.productName;
            this.productDescription=value.productDescription;
            this.price = value.price;
            this.categoryTitle = value.categoryTitle;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
}

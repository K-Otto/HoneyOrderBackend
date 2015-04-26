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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Garran
 */
@Entity
public class Stock implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String stockCode;
    private String stockName;
    private String stockDescription;
    private int quantity;
    private double price;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="stock_id")
    private List<Suppliers> suppliers;
    
    private Stock(){
        
    }
            
    public Stock(Builder builder) {
        id=builder.id;
        stockCode=builder.stockCode;
        stockName=builder.stockName;
        stockDescription=builder.stockDescription;
        quantity=builder.quantity;
        price=builder.price;
    }

    public Long getId() {
        return id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public String getStockDescription() {
        return stockDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public List<Suppliers> getSuppliers() {
        return suppliers;
    }
    
    public static class Builder{
        private Long id;
        private String stockCode;
        private String stockName;
        private String stockDescription;
        private int quantity;
        private double price;
        private List<Suppliers> suppliers;
        
        public Builder(String stockCode) {
            this.stockCode = stockCode;
        }
        
        public Builder id(Long value){
            this.id=value;
            return this;
        }
        
        public Builder stockName(String value){
            this.stockName=value;
            return this;
        }
        
        public Builder stockDescription(String value){
            this.stockDescription=value;
            return this;
        }
        
        public Builder quantity(int value){
            this.quantity=value;
            return this;
        }
        
        public Builder price(double value){
            this.price=value;
            return this;
        }
        
        public Builder suppliers(List<Suppliers> value){
            this.suppliers=value;
            return this;
        }
        
        public Stock build(){
            return new Stock(this);
        }
    }
        
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;

        Stock stock = (Stock) o;

        return !(id != null ? !id.equals(stock.id) : stock.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
        @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", stockCode='" + stockCode + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockDescription='" + stockDescription + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

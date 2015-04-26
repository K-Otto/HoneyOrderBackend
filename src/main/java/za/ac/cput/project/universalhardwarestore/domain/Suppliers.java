/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import java.util.function.Supplier;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Garran
 */
public class Suppliers implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Address address;
    private String supplierName; 
    private String supplierNumber;
    private String supplierEmail;
    
    private Suppliers() {
    }
    
    public Suppliers(Suppliers.Builder builder) {
        supplierName=builder.supplierName;
        supplierEmail=builder.supplierEmail;
    }
    
    public Address getAddress() {
        return address;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }
    
    public static class Builder{

        private Address address;
        private String supplierName;
        private String supplierNumber;
        private String supplierEmail;
        
        public Builder(String supplierName) {
            this.supplierName = supplierName;
        }

        public Builder supplierNumber(String value){
            this.supplierNumber=value;
            return this;
        }
        
        public Builder supplierEmail(String value){
            this.supplierEmail=value;
            return this;
        }

        public Suppliers build(){
            return new Suppliers(this);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Suppliers)) return false;

        Suppliers supplier = (Suppliers) o;

        return !(supplierName != null ? !supplierName.equals(supplier.supplierName) : supplier.supplierName != null);

    }
    
    @Override
    public int hashCode() {
        return supplierName != null ? supplierName.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Course{" +
                 ", supplierName='" + supplierName + '\'' +
                ", supplierNumber='" + supplierNumber + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                '}';
    }
}
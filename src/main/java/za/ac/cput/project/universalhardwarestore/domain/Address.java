/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Garran
 */
public class Address implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressID;
    @Column(unique = true)
    private String addressLine1; 
    private String addressLine2;
    private String suburb; 
    private String city;
    private String provence; 
    private String postalCode;
    
    private Address() {
    }
    
    public Address(Address.Builder builder) {
        addressID=builder.addressID;
        addressLine1=builder.addressLine1;
        addressLine2=builder.addressLine2;
        suburb=builder.suburb;
        city=builder.city;
        provence=builder.provence;
    }

    public int getAddressID() {
        return addressID;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getProvence() {
        return provence;
    }

    public String getPostalCode() {
        return postalCode;
    }
    
    public static class Builder{

        private int addressID;
        private String addressLine1;
        private String addressLine2;
        private String suburb;
        private String city;
        private String provence;
        private String postalCode;
        
        public Builder(String addressLine1) {
            this.addressLine1 = addressLine1;
        }
        
        public Builder addressID(int value){
            this.addressID=value;
            return this;
        }

        public Builder addressLine2(String value){
            this.addressLine2=value;
            return this;
        }
        
        public Builder suburb(String value){
            this.suburb=value;
            return this;
        }
        
        public Builder city(String value){
            this.city=value;
            return this;
        }
        
        public Builder provence(String value){
            this.provence=value;
            return this;
        }
        
        public Builder postalCode(String value){
            this.postalCode=value;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        return !(addressLine1 != null ? !addressLine1.equals(address.addressLine1) : address.addressLine1 != null);

    }
    
    @Override
    public int hashCode() {
        return addressLine1 != null ? addressLine1.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Course{" +
                "addressID=" + addressID +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", suburb='" + suburb + '\'' +
                ", city='" + city + '\'' +
                ", provence='" + provence + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Garran
 */
@Embeddable
public class Address implements Serializable{
    private String addressLine1; 
    private String addressLine2;
    private String suburb; 
    private String city;
    private String provence; 
    private String postalCode;
    
    private Address() {
    }
    
    public Address(Address.Builder builder) {
        addressLine1=builder.addressLine1;
        addressLine2=builder.addressLine2;
        suburb=builder.suburb;
        city=builder.city;
        provence=builder.provence;
        postalCode=builder.postalCode;
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
        private String addressLine1;
        private String addressLine2;
        private String suburb;
        private String city;
        private String provence;
        private String postalCode;
        
        public Builder(String addressLine1) {
            this.addressLine1 = addressLine1;
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
        
        public Builder copy(Address value){
            this.addressLine1=value.addressLine1;
            this.addressLine2 = value.addressLine2;
            this.city=value.city;
            this.postalCode=value.postalCode;
            this.provence=value.provence;
            this.suburb=value.suburb;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }
}

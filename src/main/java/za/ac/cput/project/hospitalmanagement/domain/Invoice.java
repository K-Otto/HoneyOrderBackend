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
public class Invoice implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceId;
    private String invoiceDate;
    private double total;
    
    public Invoice(){

    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }
    
    public double getTotal() {
        return total;
    }

    public Invoice(Builder builder){
        this.invoiceId=builder.invoiceId;
        this.invoiceDate = builder.invoiceDate;
        this.total=builder.total;
    }

    public static class Builder{
        private long invoiceId;
        private String invoiceDate;
        private double total;

        public Builder(String invoiceDate) {
            this.invoiceDate = invoiceDate;
        }

        public Builder total(double value){
            this.total=value;
            return this;
        }
        
        public Builder invoiceId(long value){
            this.invoiceId=value;
            return this;
        }

        public Builder copy(Invoice value){
            this.invoiceId=value.invoiceId;
            this.invoiceDate = value.invoiceDate;
            this.total=value.total;
            return this;
        }

        public Invoice build(){
            return new Invoice(this);
        }
    }
}

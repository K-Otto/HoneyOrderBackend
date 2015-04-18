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
public class Account implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountID;
    @Column(unique = true)
    private String status; 
    private double balance;
    
    private Account() {
    }
    
    public Account(Account.Builder builder) {
        accountID=builder.accountID;
        status=builder.status;
        balance=builder.balance;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getStatus() {
        return status;
    }

    public double getBalance() {
        return balance;
    }
    
    public static class Builder{

        private int accountID;
        private String status;
        private double balance;
        
        public Builder(String status) {
            this.status = status;
        }
        
        public Builder userID(int value){
            this.accountID=value;
            return this;
        }

        public Builder password(double value){
            this.balance=value;
            return this;
        }

        public Account build(){
            return new Account(this);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        return !(status != null ? !status.equals(account.status) : account.status != null);

    }
    
    @Override
    public int hashCode() {
        return status != null ? status.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Course{" +
                "AccountId=" + accountID +
                ", Status='" + status + '\'' +
                ", Balance='" + balance + '\'' +
                '}';
    }
    

}

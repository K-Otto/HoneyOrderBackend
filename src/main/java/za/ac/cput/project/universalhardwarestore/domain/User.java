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
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    @Column(unique = true)
    private String userName; 
    private String password;
    private String status;
    
    private User() {
    }
    
    public User(Builder builder) {
        userID=builder.userID;
        userName=builder.userName;
        password=builder.password;
        status=builder.status;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }
    
    public static class Builder{

        private int userID;
        private String userName;
        private String password;
        private String status;
        
        public Builder(String userName) {
            this.userName = userName;
        }
        
        public Builder userID(int value){
            this.userID=value;
            return this;
        }

        public Builder password(String value){
            this.password=value;
            return this;
        }

        public Builder status(String value){
            this.status=value;
            return this;
        }

        public User build(){
            return new User(this);
        }
        
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return !(userName != null ? !userName.equals(user.userName) : user.userName != null);

    }
    
    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Course{" +
                "UserId=" + userID +
                ", Username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}

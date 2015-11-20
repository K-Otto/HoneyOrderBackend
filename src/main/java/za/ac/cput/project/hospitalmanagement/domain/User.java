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
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    public User(){

    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public User(Builder builder){
        this.userId=builder.userId;
        this.username = builder.username;
        this.password=builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder{
        private long userId;
        private String username;
        private String password;
        private String firstName;
        private String lastName;

        public Builder(String username) {
            this.username = username;
        }

        public Builder password(String value){
            this.password=value;
            return this;
        }
        
        public Builder firstName(String value){
            this.firstName=value;
            return this;
        }
        
        public Builder lastName(String value){
            this.lastName=value;
            return this;
        }
        
        public Builder userId(long value){
            this.userId=value;
            return this;
        }

        public Builder copy(User value){
            this.userId=value.userId;
            this.username = value.username;
            this.password=value.password;
            this.firstName = value.firstName;
            this.lastName = value.lastName;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}

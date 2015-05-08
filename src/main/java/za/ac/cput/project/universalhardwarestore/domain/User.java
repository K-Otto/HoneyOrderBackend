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
    private Long id;
    @Column(unique = true)
    private String userName; 
    private String password;
    private String status;
    
    private User() {
    }
    
    public User(Builder builder) {
        userName=builder.userName;
        password=builder.password;
        status=builder.status;
    }
    
    public Long getId() {
        return id;
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
        private String userName;
        private String password;
        private String status;
        
        public Builder(String userName) {
            this.userName = userName;
        }

        public Builder password(String value){
            this.password=value;
            return this;
        }

        public Builder status(String value){
            this.status=value;
            return this;
        }
        
        public Builder copy(User value){
            this.userName=value.userName;
            this.password=value.password;
            this.status=value.status;
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

        return !(id != null ? !id.equals(user.id) : user.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
    
    @Override
    public String toString() {
        return "Course{" +
                ", Username='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}

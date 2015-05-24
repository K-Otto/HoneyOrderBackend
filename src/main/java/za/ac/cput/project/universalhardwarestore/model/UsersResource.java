/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.project.universalhardwarestore.model;

import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Garran
 */
public class UsersResource extends ResourceSupport{
    // Changed from id because of id in ResourceSupport
    private Long resid;
    private String userName; 
    private String password;
    private String status;

    private UsersResource() {
    }

    public Long getResid() {
        return resid;
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

    public UsersResource(Builder builder) {
        this.resid=builder.resid;
        this.password=builder.password;
        this.status=builder.status;
        this.userName=builder.userName;
    }

    public static class Builder{
        private Long resid;
        private String userName; 
        private String password;
        private String status;

        public Builder(String userName) {
            this.userName = userName;
        }

        public Builder resid(Long value){
            this.resid=value;
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

        public Builder copy(UsersResource value){
            this.password=value.password;
            this.userName = value.userName;
            this.resid=value.resid;
            this.status=value.status;
            return this;
        }

        public UsersResource build(){
            return new UsersResource(this);
        }

    }
}

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
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;
    private String categoryTitle;

    public Category(){

    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public Category(Builder builder){
        this.categoryId=builder.categoryId;
        this.categoryTitle = builder.categoryTitle;
    }

    public static class Builder{
        private long categoryId;
        private String categoryTitle;

        public Builder(String categoryTitle) {
            this.categoryTitle = categoryTitle;
        }

        public Builder categoryId(long value){
            this.categoryId=value;
            return this;
        }

        public Builder copy(Category value){
            this.categoryId=value.categoryId;
            this.categoryTitle = value.categoryTitle;
            return this;
        }

        public Category build(){
            return new Category(this);
        }
    }
}

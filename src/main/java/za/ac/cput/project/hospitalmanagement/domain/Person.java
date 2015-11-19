package za.ac.cput.project.hospitalmanagement.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Ancel on 2015/05/06.
 */
@Embeddable
public class Person implements Serializable{
    private String firstName;
    private String lastName;
    private String gender;
    private int age;

    public Person() {
    }
    
    
    
    public Person(Builder builder) {
        lastName=builder.lastName;
        firstName=builder.firstName;
        gender=builder.gender;
        age=builder.age;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public static class Builder{
        private String firstName;
        private String lastName;
        private String gender;
        private int age;
        public Builder(String firstName) {
            this.firstName = firstName;
        }
        public Builder lastName(String value){
            this.lastName=value;
            return this;
        }
        public Builder gender(String value){
            this.gender=value;
            return this;
        }
        public Builder age(int value){
            this.age=value;
            return this;
        }
        public Builder copy(Person value){
            this.lastName = value.lastName;
            this.firstName = value.firstName;
            this.gender = value.gender;
            this.age = value.age;
            return this;
        }
        public Person build(){
            return new Person(this);
        }
    }
}

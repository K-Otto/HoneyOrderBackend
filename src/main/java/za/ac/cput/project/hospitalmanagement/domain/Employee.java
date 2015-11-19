package za.ac.cput.project.hospitalmanagement.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Ancel on 2015/05/06.
 */
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeID;
    @Embedded
    private Person person;
    private String qualification;
    private String employeeType;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="treatmentID")
    Treatment treatment;
    
    
    public Employee(){
    }
    
    public long getEmployeeID() {
        return employeeID;
    }
    
    public String getQualification() {
        return qualification;
    }
    
    public String getEmployeeType() {
        return employeeType;
    }

    public Person getPerson(){
        return person;
    }
    
    public Treatment getTreatment() {
        return treatment;
    }
    
    public Employee(Builder builder){
        this.employeeID = builder.employeeID;
        this.person = builder.person;
        this.qualification = builder.qualification;
        this.employeeType = builder.employeeType;
        this.treatment = builder.treatment;
    }
    
    public static class Builder{
        private long employeeID;
        private Person person;
        private String qualification;
        private String employeeType;
        private Treatment treatment;
        
        public Builder(Person person) {
            this.person = person;
        }
   
        public Builder employeeID(long value){
            this.employeeID = value;
            return this;
        }
        
        public Builder qualification(String value){
            this.qualification=value;
            return this;
        }
        
        public Builder employeeType(String value){
            this.employeeType=value;
            return this;
        }
        
        public Builder treatment(Treatment value){
            this.treatment=value;
            return this;
        }
        
        public Builder copy(Employee value)
        {
            this.employeeID = value.employeeID;
            this.person = value.person;
            this.qualification = value.qualification;
            this.employeeType = value.employeeType;
            this.treatment = value.treatment;
            return this;
        }
        
        public Employee build(){
            return new Employee(this);
        }
    }
}
